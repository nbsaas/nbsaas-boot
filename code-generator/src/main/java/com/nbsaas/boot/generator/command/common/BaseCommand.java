package com.nbsaas.boot.generator.command.common;

import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.TableContext;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.chain2.Command;
import org.apache.commons.chain2.Processing;

import java.io.File;
import java.io.FileWriter;

public abstract class BaseCommand implements Command<String, Object, TableContext> {


    public abstract Processing handle(TableContext context);

    public abstract String outPath();


    protected TableContext tableContext;

    @Override
    public Processing execute(TableContext context) {
        this.tableContext = context;
        Config config = context.getConfig();

        context.put("repositoryPackage", config.getBasePackage() + ".data.repository");
        context.put("jpaEntityPackage", config.getBasePackage() + ".data.entity");
        context.put("resourcePackage", config.getBasePackage() + ".rest.resource");
        context.put("simplePackage", config.getBasePackage() + ".api.domain.simple");
        context.put("responsePackage", config.getBasePackage() + ".api.domain.response");
        context.put("requestPackage", config.getBasePackage() + ".api.domain.request");
        context.put("fieldPackage", config.getBasePackage() + ".api.domain.field");
        context.put("entityPackage", config.getBasePackage() + ".data.entity");
        context.put("mapperPackage", config.getBasePackage() + ".data.mapper");
        context.put("apiPackage", config.getBasePackage() + ".api.apis");
        context.put("controllerPackage", config.getBasicPackage() + ".controller." + config.getProjectName());
        context.put("convertPackage", config.getBasePackage() + ".rest.convert");
        if (context.getFormBean() != null) {
            context.put("formBean", context.getFormBean());
        }
        return handle(context);
    }

    protected void makeCode(String model, String codePackage) {
        // 初始化模板路径
        makeCode(model, model, codePackage);
    }

    protected void makeCodePackage(String model, String codePackage, String basePackage) {
        // 初始化模板路径
        makeCode(model, model, "\\src\\main\\java\\", "java", codePackage, basePackage);

    }

    protected void makeCode(String model, String className, String codePackage) {
        // 初始化模板路径
        makeCode(model, className, "\\src\\main\\java\\", "java", codePackage, tableContext.getConfig().getBasePackage());
    }

    protected void makeXml(String model, String className, String codePackage) {
        // 初始化模板路径
        makeCode(model, className, "\\src\\main\\resources\\", "xml", codePackage, tableContext.getConfig().getBasePackage());
    }

    protected void makeCode(String model, String className, String baseCode, String extension, String codeType, String basePackage) {
        // 初始化模板路径
        try {
            String codePath = basePackage + codeType;
            Config config = tableContext.getConfig();
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
            configuration.setTemplateLoader(new FileTemplateLoader(new File(config.getBase() + config.getTemplateDir())));
            Template template = configuration.getTemplate(model + ".ftl");
            String requestDir = outPath() + baseCode + codePath.replace(".", "\\");
            String outFile = requestDir + "\\" + tableContext.getTable().getName() + className + "." + extension;
            File out = new File(outFile);
            if (!out.getParentFile().exists()) {
                out.getParentFile().mkdirs();
            }
            FileWriter fileWriter = new FileWriter(outFile);
            template.process(tableContext, fileWriter);
        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

    protected void makePackage(String basePackage) {

        String packageTemp = tableContext.getConfig().getBasePackage() + basePackage;
        String requestDir = outPath() + "\\src\\main\\java\\" + packageTemp.replace(".", "\\");
        File out = new File(requestDir);
        if (!out.exists()) {
            out.mkdirs();
        }
    }
}
