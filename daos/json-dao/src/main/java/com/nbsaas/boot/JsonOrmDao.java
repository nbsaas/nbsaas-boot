package com.nbsaas.boot;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nbsaas.boot.model.api.apis.ModelApi;
import com.nbsaas.boot.model.api.apis.ModelFieldApi;
import com.nbsaas.boot.model.api.domain.response.ModelFieldResponse;
import com.nbsaas.boot.model.api.domain.response.ModelResponse;
import com.nbsaas.boot.model.api.domain.simple.ModelFieldSimple;
import com.nbsaas.boot.model.data.mapper.ModelMapper;
import com.nbsaas.boot.mp.utils.QueryWrapperUtils;
import com.nbsaas.boot.rest.api.JsonOrmApi;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.MapResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JsonOrmDao implements JsonOrmApi {

    @Resource
    private ModelApi modelApi;

    @Resource
    private ModelFieldApi modelFieldApi;

    @Resource
    private ModelMapper modelMapper;


    @Transactional(readOnly = true)
    @Override
    public PageResponse<MapResponse> search(InputStream inputStream) {
        PageResponse<MapResponse> result = new PageResponse<>();

        JSONObject search = JSON.parseObject(inputStream);
        ResponseObject<String> sqlRes = sql(search);
        if (sqlRes.getCode() != 200) {
            result.setCode(sqlRes.getCode());
            result.setMsg(sqlRes.getMsg());
            return result;
        }


        long pageNo = search.getLongValue("no", 1);
        long size = search.getLongValue("size", 10);

        // 构建查询条件


        // 执行查询
        Page<MapResponse> page = new Page<>(pageNo, size);
        Page<MapResponse> res = modelMapper.page(page, sqlRes.getData());
        return QueryWrapperUtils.handle(res);
    }

    @Override
    public ResponseObject<String> generateSql(InputStream inputStream) {
        JSONObject search = JSON.parseObject(inputStream);
        return sql(search);
    }

    private ResponseObject<String> sql(JSONObject search) {
        ResponseObject<String> result = new ResponseObject<String>();
        if (!search.containsKey("model")) {
            result.setCode(501);
            result.setMsg("缺少model参数");
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

        // 构建查询条件
        Map<String, String> operatorMap = buildOperatorMap();
        String sql = buildQuerySql(search, model, fields, operatorMap);
        result.setData(sql);
        return result;
    }

    // 构建操作符映射
    private Map<String, String> buildOperatorMap() {
        Map<String, String> operatorMap = new HashMap<>();
        operatorMap.put("eq", "=");
        operatorMap.put("like", "LIKE");
        operatorMap.put("gt", ">");
        operatorMap.put("ge", ">=");
        operatorMap.put("lt", "<");
        operatorMap.put("le", "<=");
        operatorMap.put("ne", "!=");
        return operatorMap;
    }

    // 构建查询 SQL
    private String buildQuerySql(JSONObject search, ModelResponse model, List<ModelFieldSimple> fields, Map<String, String> operatorMap) {
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

        if (search.containsKey("filters")) {
            Map<String, Integer> fieldTypes = fields.stream()
                    .collect(Collectors.toMap(ModelFieldSimple::getDbName, ModelFieldSimple::getFieldType));


            JSONArray filters = search.getJSONArray("filters");
            int index = 0;
            for (int i = 0; i < filters.size(); i++) {
                JSONObject filter = filters.getJSONObject(i);
                String field = filter.getString("field");
                Integer fieldType = fieldTypes.get(field);
                if (fieldType == null) {
                    continue;
                }
                //字段类型 1、字符串 2、Integer，3，Long，3 Float，4 Double，5，BigDecimal 6、Date 7、Boolean 8、Enum 9、对象 10、数组
                Object value = fieldTypeMatch("value", fieldType, filter);

                String operator = filter.getString("operator");
                if (operator == null) {
                    continue;
                }
                String op = operatorMap.get(operator);
                if (op == null) {
                    continue;
                }

                if ("like".equals(op)) {
                    value = "'%" + value + "%'";
                } else {
                    if (fieldType == 1 || fieldType == 6) {
                        value = "'" + value + "'";
                    }
                }
                if (index == 0) {
                    sqlBuffer.append(" where ").append(field).append(" ").append(op).append(" ").append(value);
                } else {
                    sqlBuffer.append(" and ").append(field).append(" ").append(op).append(" ").append(value);
                }
                index++;
            }
        }
        if (search.containsKey("sorts")) {
            JSONArray sorts = search.getJSONArray("sorts");
            for (int i = 0; i < sorts.size(); i++) {
                JSONObject sort = sorts.getJSONObject(i);
                String field = sort.getString("field");
                String direction = sort.getString("direction");
                String order = direction.equals("desc") ? "DESC" : "ASC";
                sqlBuffer.append(i == 0 ? " ORDER BY " : ", ").append(field).append(" ").append(order);
            }
        }

        return sqlBuffer.toString();
    }
    /**
     * 根据字段类型匹配相应的值。
     *
     * @param fieldType 字段类型。
     * @param filter    搜索过滤条件。
     * @return 返回根据字段类型处理后的值。
     */
    private Object fieldTypeMatch(String key, Integer fieldType, JSONObject filter) {
        Object value;
        if (fieldType == 1) {
            value = filter.getString(key);
        } else if (fieldType == 2) {
            value = filter.getInteger(key);
        } else if (fieldType == 3) {
            value = filter.getLong(key);
        } else if (fieldType == 4) {
            value = filter.getDouble(key);
        } else if (fieldType == 5) {
            value = filter.getBigDecimal(key);
        } else if (fieldType == 6) {
            value = filter.getDate(key);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            value = format.format(value);
        } else if (fieldType == 7) {
            value = filter.getBoolean(key);
        } else {
            value = filter.getString(key);
        }
        return value;
    }

    @Override
    public PageResponse<MapResponse> list(InputStream inputStream) {
        return null;
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
                Object value = fieldTypeMatch(fieldName, field.getFieldType(), input);
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

        modelMapper.executeSql(sqlBuffer.toString());

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

        Object id = fieldTypeMatch("id", 1, input);

        for (int i = 0; i < fields.size(); i++) {
            ModelFieldSimple field = fields.get(i);
            String fieldName = field.getDbName();
            if (input.containsKey(fieldName)) {
                Object value = fieldTypeMatch(fieldName, field.getFieldType(), input);
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

        modelMapper.executeSql(sqlBuffer.toString());

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
        Object id = fieldTypeMatch("id", field.getFieldType(), search);
        StringBuilder sqlBuffer = new StringBuilder();
        sqlBuffer.append("delete from ");
        sqlBuffer.append(model.getDbName());
        sqlBuffer.append(" where id = ");

        if (field.getFieldType() == 1) {
            sqlBuffer.append("'").append(id).append("'");
        } else {
            sqlBuffer.append(id);
        }
        modelMapper.executeSql(sqlBuffer.toString());

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

        Object id = fieldTypeMatch("id", fieldResponse.getFieldType(), search);
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
        result.setData(modelMapper.selectResponse(sqlBuffer.toString()));
        if (result.getData() == null) {
            result.setCode(501);
            result.setMsg("数据不存在");
        }

        return result;
    }
}
