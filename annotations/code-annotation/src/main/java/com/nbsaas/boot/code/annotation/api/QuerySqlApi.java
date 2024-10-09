package com.nbsaas.boot.code.annotation.api;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.code.annotation.domain.request.QueryRequest;
import com.nbsaas.boot.code.annotation.domain.simple.LeftJoinDomain;
import com.nbsaas.boot.code.annotation.domain.simple.SearchDomain;
import com.nbsaas.boot.code.annotation.orm.LeftJoin;
import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.response.ResponseObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public interface QuerySqlApi {



    default  ResponseObject<String> sql( QueryRequest request){
        return makeSql(request);
    }

   default ResponseObject<String> makeSql( QueryRequest request){

       ResponseObject<String> result = new ResponseObject<>();
       try {
           Class<?> classData = Class.forName(request.getClassName());
           StringBuffer sql = sql(classData, request.getAlias());
           result.setData(sql.toString());
       } catch (ClassNotFoundException e) {
           result.setCode(501);
           result.setMsg("类不存在");
       }
       return result;
   }

    default   List<Field> getAllFields(Class<?> object) {
        List<Field> fields = new ArrayList();

        for (Class<?> clazz = object; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fs = clazz.getDeclaredFields();
            fields.addAll(Arrays.asList(fs));
        }

        return fields;
    }


    default StringBuffer sql(Class<?> object, String alias) {
        List<Field> fields = getAllFields(object);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select ");

        List<LeftJoinDomain> joins = new ArrayList<>();

        List<SearchDomain> searchDomains=new ArrayList<>();

        Iterator<Field> iterator = fields.iterator();
        while (iterator.hasNext()) {
            Field field = iterator.next();
            TableId tableId = field.getAnnotation(TableId.class);
            if (tableId != null) {
                stringBuffer.append(alias);
                stringBuffer.append(".");
                stringBuffer.append(tableId.value());
                stringBuffer.append(" as");
                stringBuffer.append(" ");
                stringBuffer.append(field.getName());
                if (iterator.hasNext()) {
                    stringBuffer.append(",");
                }
                stringBuffer.append("\n");
            }
            TableField tableField = field.getAnnotation(TableField.class);
            if (tableField != null) {
                stringBuffer.append(alias);
                stringBuffer.append(".");
                stringBuffer.append(tableField.value());
                stringBuffer.append(" as");
                stringBuffer.append(" ");
                stringBuffer.append(field.getName());
                if (iterator.hasNext()) {
                    stringBuffer.append(",");
                }
                stringBuffer.append("\n");

                LeftJoin join = field.getAnnotation(LeftJoin.class);
                if (join != null) {
                    stringBuffer.append(join.alias());
                    stringBuffer.append(".");
                    stringBuffer.append(join.nameField());
                    stringBuffer.append(" as");
                    stringBuffer.append(" ");
                    stringBuffer.append(field.getName().replace("Code", "")).append("Name");
                    if (iterator.hasNext()) {
                        stringBuffer.append(",");
                    }
                    stringBuffer.append("\n");

                    LeftJoinDomain domain = new LeftJoinDomain();
                    domain.setTable(join.table());
                    domain.setAlias(join.alias());
                    domain.setJoinField(join.joinField());
                    domain.setOnField(tableField.value());
                    joins.add(domain);

                }
            }

            SearchItem searchItem=field.getAnnotation(SearchItem.class);
            if (searchItem!=null){
                SearchDomain domain=new SearchDomain();
                domain.setLabel(searchItem.label());
                domain.setName(searchItem.name());
                domain.setKey(searchItem.key());
                domain.setOperator(searchItem.operator());
                searchDomains.add(domain);
            }
        }


        TableName tableName = object.getAnnotation(TableName.class);
        if (tableName != null) {
            stringBuffer.append("from ");
            stringBuffer.append(tableName.value());
            stringBuffer.append(" ").append(alias);
        }
        stringBuffer.append("\n");
        for (LeftJoinDomain join : joins) {
            stringBuffer.append("left join ");
            stringBuffer.append(join.getTable());
            stringBuffer.append(" ").append(join.getAlias());
            stringBuffer.append(" on ");
            stringBuffer.append(join.getAlias());
            stringBuffer.append(".");
            stringBuffer.append(join.getJoinField());
            stringBuffer.append("=");
            stringBuffer.append(alias);
            stringBuffer.append(".");
            stringBuffer.append(join.getOnField());
            stringBuffer.append("\n");
        }

        if (!searchDomains.isEmpty()){
            stringBuffer.append("where 1=1");
        }

        for (SearchDomain searchDomain : searchDomains) {
            stringBuffer.append("<#if ").
                    append(searchDomain.getName()).
                    append("?has_content>\n");
            if (searchDomain.getOperator()== Operator.like){


                stringBuffer.
                        append(" and model.").
                        append(searchDomain.getKey()).
                        append(" like '%${").
                        append(searchDomain.getKey()).
                        append("}%'\n");


            } else if (searchDomain.getOperator()== Operator.eq) {

            }
            stringBuffer.append("</#if>\n");
        }

        return stringBuffer;
    }

}
