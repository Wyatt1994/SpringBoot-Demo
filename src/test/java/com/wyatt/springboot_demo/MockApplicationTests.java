package com.wyatt.springboot_demo;

import com.alibaba.fastjson.JSONObject;
import com.wyatt.springboot_demo.bean.City;
import com.wyatt.springboot_demo.controller.CityRestController;
import com.wyatt.springboot_demo.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
/**
 * Created by ASUS on 2019/4/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockApplicationTests {

    //注入context,用于手动获取bean
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mvc;

    private static Logger logger = LoggerFactory.getLogger(MockApplicationTests.class);
    @Before
    public void setUp() throws Exception{
        //手动注入mvc，若controller中有Autowire其他bean，则无法注入。因为没有注入上下文
//        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
        //注入上下文
//        mvc = MockMvcBuilders.webAppContextSetup(context).build();

    }

    @Test
    public void testUserController() throws Exception{
        // 测试UserController,发送json数据
        RequestBuilder request = null;

        // 1、get查一下user列表，应该为空
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        // 2、post提交一个user
        request = post("/users/")
                .param("id", "1")
                .param("name", "测试大师")
                .param("age", "20");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 3、get获取user列表，应该有刚才插入的数据
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));

        // 4、put修改id为1的user
        request = put("/users/1")
                .param("name", "测试终极大师")
                .param("age", "30");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 5、get一个id为1的user
        request = get("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));

        // 6、del删除id为1的user
        request = delete("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 7、get查一下user列表，应该为空
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }

    @Test
    public void testCityController()throws Exception{
        // 测试CityController,发送json数据
        RequestBuilder request = null;

        //将数据转换为json格式
        City city = new City();
        city.setCityName("成都");
        city.setProvinceId(3l);
        city.setDescription("我的第二故乡");
        String postJson = JSONObject.toJSONString(city);
        request = post("/city")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postJson);
        String responseString = mvc.perform(request)
                .andDo(print())         //打印出请求和相应的内容
                .andExpect(status().isOk())    //返回的状态是200
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
        logger.info(responseString);
        System.exit(1);
    }
}
