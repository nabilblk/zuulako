package com.zuulako.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "zoolako.config")
public class ZuulakoProperties {

    private String contextPath;

    public String getContextPath() {
        return contextPath != null ? contextPath : "/zuulako";
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
}
