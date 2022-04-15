package com.zkw.springboot.study.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * SpringBoot 定时任务
 */
@Slf4j
//@Component
public class BootSchedule {

    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * 上一次开始执行时间点之后3000毫秒再执行
     */
    @Scheduled(fixedRate = 3000)
    public void schedule1() {
        log.info("schedule1 -> {}", LocalDateTime.now().format(fmt));
    }

    /**
     * 上一次执行完毕时间点之后3000毫秒再执行
     */
    @Scheduled(fixedDelay = 3000)
    public void schedule2() {
        log.info("schedule2 -> {}", LocalDateTime.now().format(fmt));
    }

    /**
     * 第一延迟2000毫秒之后执行，之后按照每3000毫秒执行一次
     */
    @Scheduled(initialDelay = 2000, fixedRate = 3000)
    public void schedule3() {
        log.info("schedule3 -> {}", LocalDateTime.now().format(fmt));
    }

    /**
     * （最常用）每3s执行一次
     */
    @Scheduled(cron = "*/3 * * * * ?")
    public void schedule4() {
        log.info("schedule4 -> {}", LocalDateTime.now().format(fmt));
    }
}
