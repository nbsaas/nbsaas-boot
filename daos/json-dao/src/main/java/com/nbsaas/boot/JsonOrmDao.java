package com.nbsaas.boot;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.nbsaas.boot.model.api.apis.ModelApi;
import com.nbsaas.boot.model.api.apis.ModelFieldApi;
import com.nbsaas.boot.model.api.domain.response.ModelFieldResponse;
import com.nbsaas.boot.model.api.domain.response.ModelResponse;
import com.nbsaas.boot.model.api.domain.simple.ModelFieldSimple;
import com.nbsaas.boot.model.data.mapper.SqlExeMapper;
import com.nbsaas.boot.model.ext.apis.JsonSearchApi;
import com.nbsaas.boot.model.ext.apis.SqlGenerator;
import com.nbsaas.boot.model.ext.resource.JsonSearchResource;
import com.nbsaas.boot.model.ext.resource.SqlGeneratorResource;
import com.nbsaas.boot.model.utils.FieldTypeMatch;
import com.nbsaas.boot.rest.api.JsonOrmApi;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.MapResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

@Service
public class JsonOrmDao implements JsonOrmApi {

    private ModelApi modelApi;

    private ModelFieldApi modelFieldApi;

    @Resource
    private SqlExeMapper sqlExeMapper;


    @Transactional(readOnly = true)
    @Override
    public PageResponse<MapResponse> search(InputStream inputStream) {
        SqlGenerator sqlGenerator=new SqlGeneratorResource(modelApi,modelFieldApi);
        JsonSearchApi jsonSearchApi = new JsonSearchResource(sqlGenerator, sqlExeMapper,null);
        return jsonSearchApi.search(inputStream);
    }

    @Override
    public ResponseObject<String> generateSql(InputStream inputStream) {
        JSONObject search = JSON.parseObject(inputStream);
        SqlGenerator sqlGenerator=new SqlGeneratorResource(modelApi,modelFieldApi);

        return sqlGenerator.generateSql(search);
    }


    @Transactional(readOnly = true)
    @Override
    public ListResponse<MapResponse> list(InputStream inputStream) {
        SqlGenerator sqlGenerator=new SqlGeneratorResource(modelApi,modelFieldApi);
        JsonSearchApi jsonSearchApi = new JsonSearchResource(sqlGenerator, sqlExeMapper,null);
        return jsonSearchApi.list(inputStream);
    }

    @Override
    public ResponseObject<?> create(InputStream inputStream) {
        ResponseObject<?> result = new ResponseObject<>();
        JSONObject input = JSON.parseObject(inputStream);
        String modelKey = input.getString("model");
        ModelResponse model = modelApi.oneData(Filter.eq("id", modelKey));
        if (model == null) {
            result.setCode(501);
            result.setMsg("model不存在");
            return result;
        }
        List<ModelFieldSimple> fields = modelFieldApi.listData(Filter.eq("model_id", modelKey));
        if (fields == null || fields.isEmpty()) {
            result.setCode(501);
            result.setMsg("数据模型没有字段");
            return result;
        }

        StringBuilder sqlBuffer = new StringBuilder();
        sqlBuffer.append("INSERT INTO ").append(model.getDbName()).append(" (");

        StringBuilder valuesBuffer = new StringBuilder("VALUES (");

        for (int i = 0; i < fields.size(); i++) {
            ModelFieldSimple field = fields.get(i);
            String fieldName = field.getDbName();
            if (input.containsKey(fieldName)) {
                sqlBuffer.append(fieldName);
                Object value = FieldTypeMatch.matchType(fieldName, field.getFieldType(), input);
                if (field.getFieldType() == 1 || field.getFieldType() == 6) {
                    valuesBuffer.append("'").append(value).append("'");
                } else {
                    valuesBuffer.append(value);
                }
                if (i < fields.size() - 1) {
                    sqlBuffer.append(", ");
                    valuesBuffer.append(", ");
                }
            }
        }

        sqlBuffer.append(") ").append(valuesBuffer).append(")");

        sqlExeMapper.executeSql(sqlBuffer.toString());

        return result;
    }

    @Override
    public ResponseObject<?> update(InputStream inputStream) {
        ResponseObject<?> result = new ResponseObject<>();
        JSONObject input = JSON.parseObject(inputStream);
        if (!input.containsKey("id")) {
            result.setCode(501);
            result.setMsg("id不能为空");
            return result;
        }
        String modelKey = input.getString("model");
        ModelResponse model = modelApi.oneData(Filter.eq("id", modelKey));
        if (model == null) {
            result.setCode(501);
            result.setMsg("model不存在");
            return result;
        }
        List<ModelFieldSimple> fields = modelFieldApi.listData(Filter.eq("model_id", modelKey));
        if (fields == null || fields.isEmpty()) {
            result.setCode(501);
            result.setMsg("数据模型没有字段");
            return result;
        }

        StringBuilder sqlBuffer = new StringBuilder();
        sqlBuffer.append("UPDATE ").append(model.getDbName()).append(" SET ");

        Object id = FieldTypeMatch.matchType("id", 1, input);

        for (int i = 0; i < fields.size(); i++) {
            ModelFieldSimple field = fields.get(i);
            String fieldName = field.getDbName();
            if (input.containsKey(fieldName)) {
                Object value = FieldTypeMatch.matchType(fieldName, field.getFieldType(), input);
                sqlBuffer.append(fieldName).append(" = ");
                if (field.getFieldType() == 1 || field.getFieldType() == 6) {
                    sqlBuffer.append("'").append(value).append("'");
                } else {
                    sqlBuffer.append(value);
                }
                if (i < fields.size() - 1) {
                    sqlBuffer.append(", ");
                }
            }
        }

        sqlBuffer.append(" WHERE id = ");
        sqlBuffer.append(id);

        sqlExeMapper.executeSql(sqlBuffer.toString());

        return result;
    }

    @Override
    public ResponseObject<?> delete(InputStream inputStream) {
        ResponseObject<?> result=new  ResponseObject<>();
        JSONObject search = JSON.parseObject(inputStream);
        if (!search.containsKey("id")){
            result.setCode(501);
            result.setMsg("id不能为空");
            return result;
        }
        String modelKey = search.getString("model");
        ModelResponse model = modelApi.oneData(Filter.eq("id", modelKey));
        if (model == null) {
            result.setCode(501);
            result.setMsg("model不存在");
            return result;
        }
        ModelFieldResponse field = modelFieldApi.oneData(Filter.eq("model_id", modelKey),
                Filter.eq("dbName", "id"));
        if (field == null) {
            result.setCode(501);
            result.setMsg("数据模型没有字段");
            return result;
        }
        Object id = FieldTypeMatch.matchType("id", field.getFieldType(), search);
        StringBuilder sqlBuffer = new StringBuilder();
        sqlBuffer.append("delete from ");
        sqlBuffer.append(model.getDbName());
        sqlBuffer.append(" where id = ");

        if (field.getFieldType() == 1) {
            sqlBuffer.append("'").append(id).append("'");
        } else {
            sqlBuffer.append(id);
        }
        sqlExeMapper.executeSql(sqlBuffer.toString());

        return result;
    }

    @Override
    public ResponseObject<?> info(InputStream inputStream) {
        ResponseObject<MapResponse> result = new ResponseObject<>();
        JSONObject search = JSON.parseObject(inputStream);
        if (!search.containsKey("id")) {
            result.setCode(501);
            result.setMsg("id不能为空");
            return result;
        }
        String modelKey = search.getString("model");
        ModelResponse model = modelApi.oneData(Filter.eq("id", modelKey));
        if (model == null) {
            result.setCode(501);
            result.setMsg("model不存在");
            return result;
        }
        List<ModelFieldSimple> fields = modelFieldApi.listData(Filter.eq("model_id", modelKey));
        if (fields == null || fields.isEmpty()) {
            result.setCode(501);
            result.setMsg("数据模型没有字段");
            return result;
        }

        ModelFieldResponse fieldResponse = modelFieldApi.oneData(Filter.eq("model_id", modelKey),
                Filter.eq("dbName", "id"));
        if (fieldResponse == null) {
            result.setCode(501);
            result.setMsg("数据模型没有字段");
            return result;
        }

        Object id = FieldTypeMatch.matchType("id", fieldResponse.getFieldType(), search);
        StringBuilder sqlBuffer = new StringBuilder();
        sqlBuffer.append("SELECT ");
        for (int i = 0; i < fields.size(); i++) {
            ModelFieldSimple field = fields.get(i);
            sqlBuffer.append(field.getDbName()).append(" AS ").append(field.getJavaName());
            if (i < fields.size() - 1) {
                sqlBuffer.append(", ");
            }
        }
        sqlBuffer.append(" FROM ").append(model.getDbName());

        sqlBuffer.append(" where id = ");

        if (fieldResponse.getFieldType() == 1) {
            sqlBuffer.append("'").append(id).append("'");
        } else {
            sqlBuffer.append(id);
        }
        result.setData(sqlExeMapper.selectResponse(sqlBuffer.toString()));
        if (result.getData() == null) {
            result.setCode(501);
            result.setMsg("数据不存在");
        }

        return result;
    }
}
