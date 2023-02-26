package com.nbsaas.hibernate;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
@Component
@ConfigurationProperties(
        prefix = "nb.hibernate"
)
public class HibernateProperties {

    private Boolean show_sql;

    private Boolean format_sql;

    private String hbm2ddl;

    private List<String> entities;
}
