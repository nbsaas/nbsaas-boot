package com.nbsaas.boot.generator.command.common;

import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.TableContext;
import org.apache.commons.chain2.Processing;

public class ControllerFrontCommand extends BaseCommand {
    @Override
    public Processing handle(TableContext context) {
        makeCodePackage("FrontController", ".controller." + context.getConfig().getProjectName(), context.getConfig().getBasicPackage());
        return Processing.CONTINUE;
    }

    @Override
    public String outPath() {
        Config config = tableContext.getConfig();
        if (config.getMultiple()) {
            return config.getOutputPath() + "\\gates\\front";
        } else {
            return config.getOutputPath();
        }
    }
}
