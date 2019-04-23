package com.wyatt.springboot_demo;

import com.alibaba.fastjson.JSONObject;
import com.wyatt.springboot_demo.bean.City;
import com.wyatt.springboot_demo.dao.CityDao;
import com.wyatt.springboot_demo.service.CityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * 测试CityController功能，由于需要用到dao和service，因此需要传入webapplicationcontext。
 */
@RunWith(SpringRunner.class)
@MybatisTest
//使用自定义配置的数据源,否则使用虚拟数据源
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MybatisTests {

    @Autowired
    private CityDao cityDao;


    private static Logger logger = LoggerFactory.getLogger(MybatisTests.class);


    @Test
    //进行mybatis事务测试
    @Rollback(value = false)
    public void testCityController()throws Exception{


        City city = new City();
        city.setCityName("重庆");
        city.setProvinceId(2l);
        city.setDescription("我的家乡");
        //返回影响的条目数
        logger.info(cityDao.saveCity(city).toString());

    }
}
