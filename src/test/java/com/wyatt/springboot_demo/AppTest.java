package com.wyatt.springboot_demo;

import static org.junit.Assert.assertEquals;

import com.wyatt.springboot_demo.controller.HelloWorldController;
import org.junit.Test;

/**
 * 不带springboot上下文的测试，也就是对单个类的测试
 */
public class AppTest 
{
    @Test
    public void testSayHello(){
        assertEquals("hello wyatt",new HelloWorldController().sayHello());
    }
}
