package com.nbsaas.boot.model.utils;

import com.alibaba.fastjson2.JSONObject;

import java.text.SimpleDateFormat;

public class FieldTypeMatch {


    public static Object matchType(String key, Integer fieldType, JSONObject filter){
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
}
