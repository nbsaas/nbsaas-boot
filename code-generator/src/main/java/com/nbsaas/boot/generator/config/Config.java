package com.nbsaas.boot.generator.config;

import lombok.Data;

import java.util.List;


@Data
public class Config {


    /**
     * 是否启用多模块
     */
    private Boolean multiple;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目路径
     */
    private String outputPath;


    private String base;
    /**
     * 模板路径
     */
    private String templateDir;
    /**
     * 基础包名称
     */
    private String basePackage;
    /**
     * 实体类路径
     */
    private String entityPackage;
    /**
     * 需要生成的表
     */
    private List<String> tables;
    /**
     * 数据库连接信息
     */
    private DataBase database;

    public String getBasePackage() {
        if (multiple) {
            return basePackage + "." + projectName;
        }
        return basePackage;
    }

    public String getSimplePackage() {
        return basePackage;
    }

    public String getBasicPackage() {
        return basePackage;
    }

}
