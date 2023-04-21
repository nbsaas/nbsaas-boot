package com.nbsaas.boot.generator.command.common;

import com.nbsaas.boot.chain.Command;
import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.InputRequestObject;
import com.nbsaas.boot.rest.response.ResponseObject;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;

public abstract class BaseCommand implements Command<InputRequestObject, ResponseObject<?>> {


    protected InputRequestObject inputRequestObject;

    public abstract ResponseObject handle(InputRequestObject context);

    protected boolean overrideFile() {
        return false;
    }

    public abstract String outPath();

    @Override
    public ResponseObject execute(InputRequestObject context) {
        this.inputRequestObject = context;
        Config config = context.getConfig();

        context.put("repositoryPackage", config.getBasePackage() + ".data.repository");
        context.put("jpaEntityPackage", config.getSimplePackage() + ".entity." + context.getConfig().getProjectName());
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
        makeCode(model, className, "\\src\\main\\java\\", "java", codePackage, inputRequestObject.getConfig().getBasePackage());
    }

    protected void makeXml(String model, String className, String codePackage) {
        // 初始化模板路径
        makeCode(model, className, "\\src\\main\\resources\\", "xml", codePackage, inputRequestObject.getConfig().getBasePackage());
    }

    protected void makeCode(String model, String className, String baseCode, String extension, String codeType, String basePackage) {
        // 初始化模板路径
        try {
            String codePath = basePackage + codeType;
            Config config = inputRequestObject.getConfig();
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);

            //configuration.setTemplateLoader(new FileTemplateLoader(new File(config.getBase() + config.getTemplateDir())));
            configuration.setTemplateLoader(new ClassTemplateLoader(Template.class, config.getTemplateDir()));

            Template template = configuration.getTemplate(model + ".ftl");
            String requestDir = outPath() + baseCode + codePath.replace(".", "\\");
            String outFile = requestDir + "\\" + inputRequestObject.getFormBean().getClassName() + className + "." + extension;
            File out = new File(outFile);
            if (!out.getParentFile().exists()) {
                out.getParentFile().mkdirs();
            }
            if (!overrideFile() && out.exists()) {
                return;
            }
            FileWriter fileWriter = new FileWriter(outFile);
            template.process(inputRequestObject, fileWriter);
        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

    protected void makePackage(String basePackage) {

        String packageTemp = inputRequestObject.getConfig().getBasePackage() + basePackage;
        String requestDir = outPath() + "\\src\\main\\java\\" + packageTemp.replace(".", "\\");
        File out = new File(requestDir);
        if (!out.exists()) {
            out.mkdirs();
        }
    }
}
