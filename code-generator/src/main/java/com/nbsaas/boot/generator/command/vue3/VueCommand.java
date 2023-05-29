package com.nbsaas.boot.generator.command.vue3;

import com.nbsaas.boot.generator.beans.FormBean;
import com.nbsaas.boot.generator.command.common.BaseCommand;
import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.InputRequestObject;
import com.nbsaas.boot.rest.response.ResponseObject;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;

public class VueCommand extends BaseCommand {

    public static String toLowerCase(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        if (name.length() > 1 && Character.isUpperCase(name.charAt(1)) &&
                Character.isUpperCase(name.charAt(0))) {
            return name;
        }
        char chars[] = name.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }

    @Override
    public ResponseObject handle(InputRequestObject context) {
        Config config = inputRequestObject.getConfig();
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        FormBean formBean = context.getFormBean();

        //configuration.setTemplateLoader(new FileTemplateLoader(new File(config.getBase() + config.getTemplateDir())));
        configuration.setTemplateLoader(new ClassTemplateLoader(Template.class, config.getTemplateDir()));

        File pageDir = new File(config.getOutputPath() + "\\src\\views\\pages\\" + toLowerCase(formBean.getClassName()));
        if (!pageDir.exists()) {
            pageDir.mkdirs();
        }

        File routerDir = new File(config.getOutputPath() + "\\src\\router\\modules");

        if (formBean.isCompose()) {
            handle(routerDir, configuration, context, "router2.ftl", formBean.getClassName() + ".js");
        } else {
            handle(routerDir, configuration, context, "router.ftl", formBean.getClassName() + ".js");
        }

        //\\src\\views\\pages\\+formBean.getClassName()


        if (formBean.isCatalog()) {
            handle(pageDir, configuration, context, "tree.ftl", "index.vue");

        } else {

            handle(pageDir, configuration, context, "add.ftl", "add.vue");
            handle(pageDir, configuration, context, "index.ftl", "index.vue");
            handle(pageDir, configuration, context, "update.ftl", "update.vue");

            if (formBean.isCompose()) {
                handle(pageDir, configuration, context, "view_layout.ftl", "view_layout.vue");
                handle(pageDir, configuration, context, "view_simple.ftl", "view.vue");
            } else {
                handle(pageDir, configuration, context, "view.ftl", "view.vue");
            }

        }


        return ResponseObject.success();
    }

    private void handle(File dir, Configuration config, InputRequestObject context, String template, String out) {
        try {
            FileWriter component = new FileWriter(new File(dir, out));
            config.getTemplate(template).process(context, component);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String outPath() {
        return null;
    }
}
