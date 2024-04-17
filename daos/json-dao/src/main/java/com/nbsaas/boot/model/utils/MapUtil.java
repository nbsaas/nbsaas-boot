package com.nbsaas.boot.model.utils;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {

    public static Map<String, String> buildOperatorMap() {
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
}
