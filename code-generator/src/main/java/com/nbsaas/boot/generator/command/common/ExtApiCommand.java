package com.nbsaas.boot.generator.command.common;

import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.TableContext;
import org.apache.commons.chain2.Processing;

public class ExtApiCommand extends BaseCommand {
    @Override
    public Processing handle(TableContext context) {
        makePackage(".ext.apis");
        makePackage(".ext.domain.request");
        makePackage(".ext.domain.simple");
        makePackage(".ext.domain.response");

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
