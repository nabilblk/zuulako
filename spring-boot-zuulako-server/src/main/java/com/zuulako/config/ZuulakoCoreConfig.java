package com.zuulako.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ZuulakoProperties.class)
public class ZuulakoCoreConfig {

    private final ZuulakoProperties zuulakoProperties;

    public ZuulakoCoreConfig(ZuulakoProperties zuulakoProperties) {
        this.zuulakoProperties = zuulakoProperties;
    }
}
