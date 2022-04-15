package com.zkw.springboot.study.endpoint;

import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义端点配置类
 */
@Configuration
public class DatetimeEndpointConfig {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnAvailableEndpoint
    public DateTimeEndpoint dateTimeEndpoint() {
        return new DateTimeEndpoint();
    }
}
