package com.nbsaas.boot.utils;

import com.nbsaas.boot.filter.Condition;
import com.nbsaas.boot.filter.Filter;
import com.nbsaas.boot.filter.Search;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FilterUtils {

    public static List<Filter> getFilters(Object search) {
        List<Filter> filters = new ArrayList<Filter>();
        if (search == null) {
            return filters;
        }
        List<Field> fieldList = new ArrayList<Field>();
        Class temp = search.getClass();
        while (temp != Object.class) {
            Field[] fields = temp.getDeclaredFields();
            if (fields != null) {
                for (Field field : fields) {
                    fieldList.add(field);
                }
            }
            temp = temp.getSuperclass();
        }
        for (Field field : fieldList) {
            Search item = field.getAnnotation(Search.class);
            if (item != null) {
                field.setAccessible(true);
                Filter filter;
                try {
                    Object object = field.get(search);
                    if (object == null) {
                        continue;
                    }
                    if (object instanceof String) {
                        String oString = (String) object;
                        if (isBlank(oString)) {
                            continue;
                        }
                        object = oString.trim();
                    }


                    if (item.operator() == Filter.Operator.like) {
                        filter = new Filter(item.name(), item.operator(), "%" + object + "%");
                        filter.setPrefix(item.prefix());
                    } else {
                        filter = new Filter(item.name(), item.operator(), object);
                        filter.setPrefix(item.prefix());
                    }

                    if (item.condition() == Condition.AND) {
                        filter.setCondition("and");
                    } else {
                        filter.setCondition("or");
                    }
                    filters.add(filter);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return filters;
    }


    public static boolean isBlank(final CharSequence cs) {
        final int strLen = length(cs);
        if (strLen == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int length(final CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }

}
