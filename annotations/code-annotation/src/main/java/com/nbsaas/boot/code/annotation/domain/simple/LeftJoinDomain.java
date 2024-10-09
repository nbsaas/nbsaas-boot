package com.nbsaas.boot.code.annotation.domain.simple;

import lombok.Data;

@Data
public class LeftJoinDomain {

    private String table;  //连接表名称
    private String alias; //别名
    private String joinField;//连接字段
    private String onField;//主表字段

}
