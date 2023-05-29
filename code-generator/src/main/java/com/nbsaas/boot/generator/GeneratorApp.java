package com.nbsaas.boot.generator;

import com.nbsaas.boot.chain.impl.ChainBase;
import com.nbsaas.boot.generator.beans.FormBean;
import com.nbsaas.boot.generator.beans.FormBeanConvert;
import com.nbsaas.boot.generator.command.common.*;
import com.nbsaas.boot.generator.command.vue3.VueCommand;
import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.InputRequestObject;
import com.nbsaas.boot.rest.response.ResponseObject;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class GeneratorApp {

    public static void main(String[] args) throws Exception {

        //config/bootadmin/system.yml
        //config/bootadmin/user.yml
        generator("config/vue/ad.yml");

    }

    public static void generator(String configFile) throws Exception {
        Yaml yaml = new Yaml();
        String baseFile = GeneratorApp.class.getClassLoader().getResource("").getFile();
        File f = new File(baseFile + configFile);
        //读入文件

        Config config = yaml.loadAs(Files.newInputStream(f.toPath()), Config.class);
        config.setBase(baseFile);

        List<String> tables = config.getEntities();
        if (tables == null) {
            return;
        }
        for (String table : tables) {

            FormBean formBean = new FormBeanConvert().convertClass(Class.forName(config.getEntityPackage() + "." + table));

            ChainBase<InputRequestObject, ResponseObject<?>> chainBase = new ChainBase<>();
//            chainBase.addCommand(new DomainCommand());
//            chainBase.addCommand(new ApiCommand());
//            chainBase.addCommand(new ConvertCommand());
//            chainBase.addCommand(new ControllerAdminCommand());
//            chainBase.addCommand(new ControllerFrontCommand());
//            chainBase.addCommand(new RestCommand());
//            chainBase.addCommand(new ExtApiCommand());
            chainBase.addCommand(new VueCommand());
            chainBase.addCommand(new FinishCommand());

            InputRequestObject context = new InputRequestObject();
            context.setConfig(config);
            context.setFormBean(formBean);
            chainBase.execute(context);
        }
    }
}
