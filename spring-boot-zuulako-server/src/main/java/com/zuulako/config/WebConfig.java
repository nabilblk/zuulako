package com.zuulako.config;

import com.zuulako.api.MainController;
import com.zuulako.web.PrefixHandlerMapping;
import com.zuulako.web.ZuulakoController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Map;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private final  ZuulakoProperties zuulakoProperties;
    private final ServerProperties server;


    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


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

    @Bean
    public PrefixHandlerMapping prefixHandlerMapping() {
        Map<String, Object> beans = applicationContext
                .getBeansWithAnnotation(ZuulakoController.class);
        PrefixHandlerMapping prefixHandlerMapping = new PrefixHandlerMapping(
                beans.values().toArray(new Object[beans.size()]));
        prefixHandlerMapping.setPrefix(zuulakoProperties.getContextPath());
        return prefixHandlerMapping;
    }


    /*
    Zuulako Controllers are declared here
     */

    @Bean
    @ConditionalOnMissingBean
    public MainController registryController() {
        return new MainController();
    }
}
