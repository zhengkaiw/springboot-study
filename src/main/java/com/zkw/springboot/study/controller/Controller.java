package com.zkw.springboot.study.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zkw.springboot.study.config.SpringBootConfig;
import com.zkw.springboot.study.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 测试 Controller
 */
@Slf4j
@RestController
@RequestMapping("/springboot")
public class Controller {

    /** SpringBoot config */
    private final SpringBootConfig springBootConfig;

    private final ObjectMapper mapper;

    @Value("${study.springboot.version}")
    private String version;
    @Value("${study.springboot.name}")
    private String name;

    @Autowired
    public Controller(SpringBootConfig springBootConfig, ObjectMapper mapper) {
        this.springBootConfig = springBootConfig;
        this.mapper = mapper;
    }

    /**
     * 第一种方式的数据注入
     * 127.0.0.1:8000/study/springboot/conf_inject_1
     */
    @GetMapping("/conf_inject_1")
    public void firstConfInject() {
        log.info("first conf inject: {}, {}", version, name);
    }

    /**
     * 第二种方式的数据注入
     * 127.0.0.1:8000/study/springboot/conf_inject_2
     */
    @GetMapping("/conf_inject_2")
    public void secondConfInject() {
        log.info("second conf inject: {}, {}",
                springBootConfig.getVersion(), springBootConfig.getName());
    }

    /**
     * 127.0.0.1:8000/study/springboot/jackson
     */
    @GetMapping("/jackson")
    public User jackson() throws Exception {
        User user = User.builder()
                .name("test")
                .age(18)
                .address("Beijing")
                .registerTime(new Date())
                .build();

        String jsonUser = mapper.writeValueAsString(user);
        log.info("user jackson: {}", jsonUser);

        return mapper.readValue(jsonUser, User.class);
    }
}
