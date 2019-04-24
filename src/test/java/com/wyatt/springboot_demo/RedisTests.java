package com.wyatt.springboot_demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ASUS on 2019/4/24.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis() throws Exception{
        //添加字符串
        stringRedisTemplate.opsForValue().set("aaa","wyatt");
        Assert.assertEquals("wyatt",stringRedisTemplate.opsForValue().get("aaa"));
    }
}
