package com.nbsaas.boot.generator.config;


import lombok.Data;

import java.util.List;

@Data
public class DataBase {

    private String ip;

    private Integer port;

    private String databaseName;

    private String username;

    private String password;

    private String driver;

    private List<String> tableRemovePrefixes;
}
