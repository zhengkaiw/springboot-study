package com.zkw.springboot.study.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * SpringBoot 配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "study.springboot")
public class SpringBootConfig {

    private String version;
    private String name;
}
