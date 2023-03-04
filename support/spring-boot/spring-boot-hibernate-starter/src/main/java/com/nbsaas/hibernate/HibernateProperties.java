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

    private Boolean show_sql=false;

    private Boolean format_sql=false;

    private String hbm2ddl;

    private String dialect;

    private List<String> entities;
}
