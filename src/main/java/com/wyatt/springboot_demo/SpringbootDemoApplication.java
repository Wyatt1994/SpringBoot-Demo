package com.wyatt.springboot_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

//Spring boot 应用标识
@SpringBootApplication
//mapper接口类扫描包配置
@MapperScan("com.wyatt.springboot_demo.dao")
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		// 程序启动入口
		// 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

}
