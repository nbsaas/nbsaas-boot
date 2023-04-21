package com.nbsaas.boot.generator.command.common;

import com.nbsaas.boot.generator.command.common.BaseCommand;
import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.InputRequestObject;
import com.nbsaas.boot.rest.response.ResponseObject;

public class ControllerAdminCommand extends BaseCommand {
    @Override
    public ResponseObject handle(InputRequestObject context) {
        makeCodePackage("Controller", ".controller." + context.getConfig().getProjectName(), context.getConfig().getBasicPackage());
        return ResponseObject.success();
    }

    @Override
    public String outPath() {
        Config config = inputRequestObject.getConfig();
        if (config.getMultiple()) {
            return config.getOutputPath() + "\\gates\\admin";
        } else {
            return config.getOutputPath();
        }
    }
}
