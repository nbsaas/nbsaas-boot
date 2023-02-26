package com.nbsaas.boot.generator.command.hibernate;

import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.TableContext;
import org.apache.commons.chain2.Processing;

public class DomainCommand extends BaseCommand {
    @Override
    public Processing handle(TableContext context) {
        makeCode("DataRequest", ".api.domain.request");
        makeCode("SearchRequest", ".api.domain.request");
        makeCode("Response", ".api.domain.response");
        makeCode("Simple", ".api.domain.simple");
        return Processing.CONTINUE;
    }

    @Override
    public String outPath() {
        Config config = tableContext.getConfig();
        if (config.getMultiple()) {
            return config.getOutputPath() + "\\apis\\[[]]-api".replace("[[]]", config.getProjectName());
        } else {
            return config.getOutputPath();
        }
    }
}
