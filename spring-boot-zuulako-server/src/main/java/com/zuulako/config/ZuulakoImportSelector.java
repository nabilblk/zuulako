package com.zuulako.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ZuulakoImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                ZuulakoCoreConfig.class.getCanonicalName(),
                WebConfig.class.getCanonicalName()
        };
    }
}
