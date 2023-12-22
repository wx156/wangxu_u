package com.kfm.shop.system.config;

import com.kfm.shop.system.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login","/webjars/springfox-swagger-ui/*"
                        ,"/swagger-ui.html/*","/error","/favicon.ico","/swagger-ui.html"
                        ,"/null/swagger-resources/configuration/ui","/swagger-ui.html/swagger-resources/configuration/*");
    }
}
