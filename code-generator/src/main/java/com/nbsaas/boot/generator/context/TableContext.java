package com.nbsaas.boot.generator.context;

import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.domain.Table;
import com.nbsaas.codemake.fields.FormBean;
import lombok.Data;
import org.apache.commons.chain2.impl.ContextMap;


@Data
public class TableContext extends ContextMap<String, Object> {

    private Table table;

    private Config config;
    private FormBean formBean;
}
