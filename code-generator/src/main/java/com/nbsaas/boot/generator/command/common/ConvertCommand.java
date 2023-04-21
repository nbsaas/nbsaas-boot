package com.nbsaas.boot.generator.command.common;

import com.nbsaas.boot.generator.command.common.BaseCommand;
import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.InputRequestObject;
import com.nbsaas.boot.rest.response.ResponseObject;

public class ConvertCommand extends BaseCommand {

    @Override
    public ResponseObject handle(InputRequestObject context) {
        makeCode("EntityConvert", ".rest.convert");
        makeCode("ResponseConvert", ".rest.convert");
        makeCode("SimpleConvert", ".rest.convert");
        return ResponseObject.success();
    }

    @Override
    public String outPath() {
        Config config = inputRequestObject.getConfig();
        if (config.getMultiple()) {
            return config.getOutputPath() + "\\resources\\[[]]-resource".replace("[[]]", config.getProjectName());
        } else {
            return config.getOutputPath();
        }
    }

}
