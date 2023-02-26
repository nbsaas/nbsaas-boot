package com.nbsaas.boot.generator.command.hibernate;

import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.TableContext;
import org.apache.commons.chain2.Processing;

public class ApiCommand extends BaseCommand {
    @Override
    public Processing handle(TableContext context) {
        makeCode("Api", ".api.apis");
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
