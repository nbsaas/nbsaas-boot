package com.nbsaas.boot.generator;

import freemarker.cache.ClassTemplateLoader;

public class App {

    public static void main(String[] args) {
        ClassTemplateLoader ctl = new ClassTemplateLoader();
        System.out.println(ctl.getBasePackagePath());
    }
}
