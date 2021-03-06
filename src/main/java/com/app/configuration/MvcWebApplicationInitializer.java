package com.app.configuration;

import com.app.configuration.rabbitMq.RabbitMQConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

    public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Load database and spring security configuration
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{PersistenceJPAConfig.class, WebSecurityConfig.class, RabbitMQConfig.class};
    }

    // Load spring web configuration
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}