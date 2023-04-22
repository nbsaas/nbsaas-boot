package com.nbsaas.boot.generator.command.common;

import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.InputRequestObject;
import com.nbsaas.boot.rest.response.ResponseObject;

public class ControllerAppCommand extends BaseCommand {
    @Override
    public ResponseObject handle(InputRequestObject context) {
        makeCodePackage("AppController", ".controller." + context.getConfig().getProjectName(), context.getConfig().getBasicPackage());
        return ResponseObject.success();
    }
    @Override
    public String outPath() {
        Config config = inputRequestObject.getConfig();
        if (config.getMultiple()) {
            return config.getOutputPath() + "\\apps\\[[]]-app".replace("[[]]", config.getProjectName());
        } else {
            return config.getOutputPath();
        }
    }
}
