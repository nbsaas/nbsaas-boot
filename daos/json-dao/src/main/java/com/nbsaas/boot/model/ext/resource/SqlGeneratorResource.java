package com.nbsaas.boot.model.ext.resource;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.nbsaas.boot.model.api.apis.ModelApi;
import com.nbsaas.boot.model.api.apis.ModelFieldApi;
import com.nbsaas.boot.model.api.domain.response.ModelResponse;
import com.nbsaas.boot.model.api.domain.simple.ModelFieldSimple;
import com.nbsaas.boot.model.ext.apis.PermissionCheck;
import com.nbsaas.boot.model.ext.apis.SqlGenerator;
import com.nbsaas.boot.model.utils.FieldTypeMatch;
import com.nbsaas.boot.model.utils.MapUtil;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ResponseObject;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SqlGeneratorResource implements SqlGenerator {

    private final ModelApi modelApi;

    private final ModelFieldApi modelFieldApi;

    public SqlGeneratorResource(ModelApi modelApi, ModelFieldApi modelFieldApi) {
        this.modelApi = modelApi;
        this.modelFieldApi = modelFieldApi;
    }

    @Setter
    private PermissionCheck permissionCheck;


    @Override
    public ResponseObject<String> generateSql(JSONObject search) {
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
        if (permissionCheck != null) {
            if (!permissionCheck.check(modelKey)) {
                result.setCode(502);
                result.setMsg("权限不够");
                return result;
            }
        }

        List<ModelFieldSimple> fields = modelFieldApi.listData(Filter.eq("model_id", modelKey));
        if (fields == null || fields.isEmpty()) {
            result.setCode(501);
            result.setMsg("数据模型没有字段");
            return result;
        }

        // 构建查询条件
        Map<String, String> operatorMap = MapUtil.buildOperatorMap();
        String sql = buildQuerySql(search, model, fields, operatorMap);
        result.setData(sql);
        return result;
    }

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
                Object value = FieldTypeMatch.matchType("value", fieldType, filter);

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


}
