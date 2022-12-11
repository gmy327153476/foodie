package com.soft;

import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @Author: Mengyuan Guo
 * @Description:
 * @Date: 2021/10/19 16:09
 */
@SpringBootApplication
public class FoodieDevApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodieDevApplication.class, args);
    }

    /**
     * cookie设置
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> cookieProcessorCustomizer() {
        return (factory) -> factory.addContextCustomizers(
                (context) -> context.setCookieProcessor(new LegacyCookieProcessor()));
    }
}
