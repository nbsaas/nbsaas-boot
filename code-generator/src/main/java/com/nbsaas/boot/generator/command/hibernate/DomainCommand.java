package com.nbsaas.boot.generator.command.hibernate;

import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.InputRequestObject;
import com.nbsaas.boot.rest.response.ResponseObject;

public class DomainCommand extends BaseCommand {
    @Override
    public ResponseObject handle(InputRequestObject context) {
        makeCode("DataRequest", ".api.domain.request");
        makeCode("SearchRequest", ".api.domain.request");
        makeCode("Response", ".api.domain.response");
        makeCode("Simple", ".api.domain.simple");
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
