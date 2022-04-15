package com.zkw.springboot.study.servcie;

import com.zkw.springboot.study.async.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步服务功能测试
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncServiceTest {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void testAsyncProcess() throws InterruptedException {

        asyncService.asyncProcess();
        log.info("coming in testAsyncProcess...");
    }

    @Test
    public void testAsyncProcessHasReturn() throws Exception {

        long start = System.currentTimeMillis();

        Future<Integer> result = asyncService.asyncProcessHasReturn();
        log.info("get async task value: {}", result.get());
        // 超时抛出异常
//        log.info("get async task value: {}",
//                result.get(1, TimeUnit.SECONDS));
        log.info("time elapse for async task: {}ms",
                System.currentTimeMillis() - start);

    }
}
