package com.nbsaas.boot.generator.command.mybatis;

import com.nbsaas.boot.generator.command.common.BaseCommand;
import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.InputRequestObject;
import com.nbsaas.boot.generator.utils.OsUtils;
import com.nbsaas.boot.rest.response.ResponseObject;

import java.io.File;

public class MapperXmlCommand extends BaseCommand {
    @Override
    public ResponseObject handle(InputRequestObject inputRequestObject) {
        Config config = this.inputRequestObject.getConfig();
        this.makeXmlPackage("." + config.getModuleName() + ".data.mapper");
        return ResponseObject.success();

    }
    protected void makeXmlPackage(String basePackage) {
        String packageTemp = this.inputRequestObject.getConfig().getBasePackage() + basePackage;
        String requestDir = this.outPath() + "\\src\\main\\resources\\" + packageTemp.replace(".", "\\");
        if (OsUtils.isLinuxOrMac()){
            requestDir=requestDir.replace("\\","/");
        }
        File out = new File(requestDir);
        if (!out.exists()) {
            out.mkdirs();
        }

    }
    @Override
    public String outPath() {
        Config config = this.inputRequestObject.getConfig();
        return config.getMultiple() ? config.getOutputPath() + "\\resources\\[[]]-resource".replace("[[]]", config.getProjectName()) : config.getOutputPath();
    }
}
