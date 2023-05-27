package com.example.email.common.utils;


import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;

public class ThymeleafValidator {
    public static boolean isValidThymeleafExpression(String template) {
        TemplateEngine templateEngine = new TemplateEngine();
        StringTemplateResolver templateResolver = new StringTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateEngine.setTemplateResolver(templateResolver);

        try {
            Context context = new Context();
            templateEngine.process(template, context);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
