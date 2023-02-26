package com.nbsaas.boot.generator;

import com.nbsaas.boot.generator.command.common.ExtApiCommand;
import com.nbsaas.boot.generator.command.common.FinishCommand;
import com.nbsaas.boot.generator.command.hibernate.*;
import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.TableContext;
import com.nbsaas.codemake.fields.FormBean;
import com.nbsaas.codemake.fields.FormBeanConvert;
import org.apache.commons.chain2.impl.ChainBase;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;

public class HibernateApp {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        //config/bootadmin/system.yml
        //config/bootadmin/user.yml
        makeCodes("config/boot/trade.yml");
        makeCodes("config/boot/system.yml");
        makeCodes("config/boot/ad.yml");
        makeCodes("config/boot/user.yml");
        makeCodes("config/boot/tenant.yml");

    }

    private static void makeCodes(String configFile) throws IOException, SQLException, ClassNotFoundException {
        Yaml yaml = new Yaml();
        String baseFile = HibernateApp.class.getClassLoader().getResource("").getFile();
        File f = new File(baseFile + configFile);
        //读入文件

        Config config = yaml.loadAs(Files.newInputStream(f.toPath()), Config.class);
        config.setBase(baseFile);

        List<String> tables = config.getTables();
        if (tables == null) {
            return;
        }
        for (String table : tables) {

            FormBean formBean = new FormBeanConvert().convertClass(Class.forName(config.getEntityPackage() + "." + table));

            ChainBase<String, Object, TableContext> chainBase = new ChainBase<>();
            chainBase.addCommand(new DomainCommand());
            chainBase.addCommand(new ApiCommand());
            chainBase.addCommand(new ConvertCommand());
            chainBase.addCommand(new ControllerAdminCommand());
            chainBase.addCommand(new ControllerFrontCommand());
            chainBase.addCommand(new RestCommand());
            chainBase.addCommand(new ExtApiCommand());
            chainBase.addCommand(new FinishCommand());

            TableContext context = new TableContext();
            context.setConfig(config);
            context.setFormBean(formBean);
            chainBase.execute(context);
        }
    }
}
