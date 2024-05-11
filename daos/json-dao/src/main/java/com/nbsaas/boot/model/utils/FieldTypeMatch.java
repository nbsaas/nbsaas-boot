package com.nbsaas.boot.model.utils;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FieldTypeMatch {


    /**
     * 匹配类型,减少sql注入
     *
     * @param key
     * @param fieldType
     * @param filter
     * @return
     */
    public static Object matchType(String key, Integer fieldType, JSONObject filter) {
        /**
         * 字段类型字段类型 字段类型 1、字符串 2、Integer，3，Long，3 Float，4 Double，5，BigDecimal 6、Date 7、Boolean 8、Enum 9、对象 10、字符数组,11,整形数组，12小数数组
         */
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
        } else if (fieldType == 10) {
            //字符数组
            String temp = filter.getString(key);
            if (temp == null) {
                return null;
            }
            String[] strs = temp.split(",");
            value = Arrays.stream(strs).
                    map(String::trim).
                    filter(StringUtils::hasText).
                    map(s -> "'" + s + "'").
                    collect(Collectors.joining(","));
            value = "(" + value + ")";
        } else if (fieldType == 11) {
            //整形数组
            String temp = filter.getString(key);
            if (temp == null) {
                return null;
            }
            String[] stars = temp.split(",");
            value = Arrays.stream(stars).
                    map(String::trim).
                    filter(StringUtils::hasText).
                    map(Long::valueOf).
                    map(String::valueOf).
                    collect(Collectors.joining(","));
            value = "(" + value + ")";
        } else if (fieldType == 12) {
            //小数数组
            String temp = filter.getString(key);
            if (temp == null) {
                return null;
            }
            String[] stars = temp.split(",");
            value = Arrays.stream(stars).
                    map(String::trim).
                    filter(StringUtils::hasText).
                    map(Double::valueOf).
                    map(String::valueOf).
                    collect(Collectors.joining(","));
            value = "(" + value + ")";
        }else if (fieldType == 101){
            value = filter.getString(key);
        } else {
            value = filter.getString(key);
        }
        return value;
    }
}
