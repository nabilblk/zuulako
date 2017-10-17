package com.zuulako.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    private final  ZuulakoProperties zuulakoProperties;
    private final ServerProperties server;

    public WebConfig(ZuulakoProperties zuulakoProperties, ServerProperties server) {
        this.zuulakoProperties = zuulakoProperties;
        this.server = server;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String context = zuulakoProperties.getContextPath();

        System.out.println("++++++++++++ " + context + "++++++++++++++++++");

        registry
                .addResourceHandler(zuulakoProperties.getContextPath() + "/**")
                .addResourceLocations("classpath:/static/");


    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        String contextPath = zuulakoProperties.getContextPath();
        if (StringUtils.hasText(contextPath)) {
            registry.addRedirectViewController(contextPath, server.getPath(contextPath) + "/");
        }
        registry.addViewController(contextPath + "/").setViewName("forward:index.html");
    }
}
