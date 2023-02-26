package com.nbsaas.boot.generator.command.hibernate;

import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.TableContext;
import org.apache.commons.chain2.Processing;

public class ControllerAdminCommand extends BaseCommand {
    @Override
    public Processing handle(TableContext context) {
        makeCodePackage("Controller", ".controller." + context.getConfig().getProjectName(), context.getConfig().getBasicPackage());
        return Processing.CONTINUE;
    }

    @Override
    public String outPath() {
        Config config = tableContext.getConfig();
        if (config.getMultiple()) {
            return config.getOutputPath() + "\\gates\\admin";
        } else {
            return config.getOutputPath();
        }
    }
}
