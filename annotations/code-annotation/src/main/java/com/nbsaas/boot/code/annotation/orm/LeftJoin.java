package com.nbsaas.boot.code.annotation.orm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * 左连接注解
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface LeftJoin {

    String table();  //连接表名称

    String alias(); //别名

    String joinField();//连接字段

    String nameField();//显示字段

}
