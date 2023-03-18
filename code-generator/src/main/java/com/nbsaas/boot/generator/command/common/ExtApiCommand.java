package com.nbsaas.boot.generator.command.common;

import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.InputRequestObject;
import com.nbsaas.boot.rest.response.ResponseObject;

public class ExtApiCommand extends BaseCommand {
    @Override
    public ResponseObject handle(InputRequestObject context) {
        makePackage(".ext.apis");
        makePackage(".ext.domain.request");
        makePackage(".ext.domain.simple");
        makePackage(".ext.domain.response");

        return ResponseObject.success();
    }

    @Override
    public String outPath() {
        Config config = inputRequestObject.getConfig();
        if (config.getMultiple()) {
            return config.getOutputPath() + "\\apis\\[[]]-api".replace("[[]]", config.getProjectName());
        } else {
            return config.getOutputPath();
        }
    }
}
