package com.nytd.retail.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    /**
     * 资源映射\\
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

         registry.addResourceHandler("/files/engine/**").addResourceLocations("file:C:\\Users\\92872\\Desktop\\engine\\files\\");

    }


}