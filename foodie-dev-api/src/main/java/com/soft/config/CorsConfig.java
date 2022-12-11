package com.soft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

/**
 * @Author: Mengyuan Guo
 * @Description: 跨域配置
 * @Date: 2021/11/2 11:38
 */
@Configuration
public class CorsConfig {
    public CorsConfig() {

    }

    /**
     * 配置前后端跨域
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        // 1. 添加cors配置信息
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:8585");
        configuration.addAllowedOrigin("*");
        //设置是否发送cookie信息
        configuration.setAllowCredentials(true);
        //设置允许请求的方式
        configuration.addAllowedMethod("*");
        //设置允许的header
        configuration.setAllowedHeaders(Collections.singletonList("*"));

        // 2.为url添加映射路径
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", configuration);

        // 3.返回重新定义好的corsSource
        return new CorsFilter(corsConfigurationSource);
    }
}
