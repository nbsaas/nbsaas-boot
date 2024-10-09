package com.nbsaas.boot.code.annotation.domain.simple;

import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;

@Data
public class SearchDomain {


    private String label;//搜索中文

    private String name;//业务字段

    private String key;//数据库字段

    Operator operator;//操作符
}
