/*
 *
 *  * 版权声明和许可协议
 *  *
 *  * 版权所有 (c) 2023 纽百特®
 *  * 版权所有，保留所有权利
 *  *
 *  * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *  *
 *  *   https://opensource.org/licenses/MIT
 *  *
 *  * 更多信息，请访问我们的网站：
 *  *
 *  *   http://www.nbsaas.com
 *  *
 *  * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 *
 */

/*
 *
 *  * 版权声明和许可协议
 *  *
 *  * 版权所有 (c) 2023 纽百特®
 *  * 版权所有，保留所有权利
 *  *
 *  * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *  *
 *  *   https://opensource.org/licenses/MIT
 *  *
 *  * 更多信息，请访问我们的网站：
 *  *
 *  *   http://www.nbsaas.com
 *  *
 *  * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 *
 */

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
    protected boolean overrideFile;

    public boolean isOverrideFile() {
        return overrideFile;
    }

    public void setOverrideFile(boolean overrideFile) {
        this.overrideFile = overrideFile;
    }

    public abstract ResponseObject handle(InputRequestObject context);

    public abstract String outPath();

    @Override
    public ResponseObject execute(InputRequestObject context) {
        this.inputRequestObject = context;
        Config config = context.getConfig();

        context.put("repositoryPackage", config.getBasePackage() + ".data.repository");
        context.put("jpaEntityPackage", config.getEntityPackage());
        context.put("resourcePackage", config.getBasePackage() + ".rest.resource");
        context.put("simplePackage", config.getBasePackage() + ".api.domain.simple");
        context.put("responsePackage", config.getBasePackage() + ".api.domain.response");
        context.put("requestPackage", config.getBasePackage() + ".api.domain.request");
        context.put("fieldPackage", config.getBasePackage() + ".api.domain.field");
        context.put("entityPackage", config.getEntityPackage());
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
            if (!isOverrideFile() && out.exists()) {
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
