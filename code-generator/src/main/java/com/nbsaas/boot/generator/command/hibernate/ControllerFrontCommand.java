package com.nbsaas.boot.generator.command.hibernate;

import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.InputRequestObject;
import com.nbsaas.boot.rest.response.ResponseObject;

public class ControllerFrontCommand extends BaseCommand {
    @Override
    public ResponseObject handle(InputRequestObject context) {
        makeCodePackage("FrontController", ".controller." + context.getConfig().getProjectName(), context.getConfig().getBasicPackage());
        return ResponseObject.success();
    }

    @Override
    public String outPath() {
        Config config = inputRequestObject.getConfig();
        if (config.getMultiple()) {
            return config.getOutputPath() + "\\gates\\front";
        } else {
            return config.getOutputPath();
        }
    }
}
