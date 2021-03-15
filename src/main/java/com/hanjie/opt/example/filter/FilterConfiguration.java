package com.hanjie.opt.example.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author han
 * @date 2021/3/1
 */
@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<AdminOptContextFilter>
    adminOptContextFilterFilterRegistrationBean() {
        FilterRegistrationBean<AdminOptContextFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new AdminOptContextFilter());
        registration.addUrlPatterns("/admin/*");
        registration.setName("adminOptContextFilter");
        registration.setOrder(100);
        return registration;
    }

    @Bean
    public FilterRegistrationBean<UserOptContextFilter> userOptContextFilterFilterRegistrationBean() {
        FilterRegistrationBean<UserOptContextFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new UserOptContextFilter());
        registration.addUrlPatterns("/user/*");
        registration.setName("userOptContextFilter");
        registration.setOrder(120);
        return registration;
    }
}
