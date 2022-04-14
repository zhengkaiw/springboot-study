package com.zkw.springboot.study;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 应用启动类
 */
@SpringBootApplication
public class SpringBootStudyApplication {

    public static void main(String[] args) {
        // 1.通过静态 run 方法
        SpringApplication.run(SpringBootStudyApplication.class, args);

        // 2.通过 api 调整行为
//        SpringApplication application = new SpringApplication(SpringBootStudyApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.setWebApplicationType(WebApplicationType.NONE);
//        application.run(args);

        // 3. SpringApplicationBuilder Fluent Api, 链式调用
//        new SpringApplicationBuilder(SpringBootStudyApplication.class)
//                .bannerMode(Banner.Mode.OFF)
//                .web(WebApplicationType.NONE)
//                .run(args);
    }
}
