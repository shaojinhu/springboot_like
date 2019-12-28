package com.sjh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * 将自定义jwt拦截器加入到springboot拦截池中
 */
@Configuration
public class JwtConfig extends WebMvcConfigurationSupport {

    @Resource
    private jwtInterceptor jwtInterceptor;

    /**
     * 添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //添加拦截器，设置拦截路径，设置放行路径
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
        super.addInterceptors(registry);
    }

    /**
     * 设置跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置跨域
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowedOrigins("*");
        super.addCorsMappings(registry);
    }


}
