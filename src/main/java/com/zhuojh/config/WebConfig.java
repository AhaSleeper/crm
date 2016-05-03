package com.zhuojh.config;

import com.zhuojh.core.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.MappedInterceptor;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

/**
 * Created by Administrator on 2016/4/22.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
    @Autowired
    private AuthInterceptor authInterceptor;

    @Bean
    public MappedInterceptor getMappedInterceptor() {
        MappedInterceptor interceptor = new MappedInterceptor(new String[]{"/","/user/**","/data/**","/role/**","/menu/**","/loadUserMenu",
                "/customer/**","/contact/**","/contactHistory/**","/customerDevPlan/**","/salesOppotunity/**"}, authInterceptor);
        return interceptor;
    }
}
