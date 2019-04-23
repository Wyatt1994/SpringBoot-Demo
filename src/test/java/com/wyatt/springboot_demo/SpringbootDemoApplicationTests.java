package com.wyatt.springboot_demo;

import com.wyatt.springboot_demo.property.BlogProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {

	@Autowired
	private BlogProperties blogProperties;

	private static Logger logger = LoggerFactory.getLogger(SpringbootDemoApplicationTests.class);

	@Value("${com.wyatt.blog.value}")
	private String randomString;
	@Test
	public void getProperties()throws Exception{
//        Assert.assertEquals(blogProperties.getName(),"程序猿wyatt");
//        Assert.assertEquals(blogProperties.getTitle(),"wyatt的springboot学习");
		logger.info(blogProperties.getName());
		logger.info(randomString);
	}
	@Test
	public void contextLoads() {
	}

}
