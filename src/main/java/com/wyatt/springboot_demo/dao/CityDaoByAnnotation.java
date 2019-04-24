package com.wyatt.springboot_demo.dao;

import com.wyatt.springboot_demo.bean.City;
import org.apache.ibatis.annotations.*;

/**
 * Mybatis注解
 */

@Mapper
public interface CityDaoByAnnotation {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    @Select("SELECT * FROM city where city_name=${cityName}")
// 返回 Map 结果集
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description"),
    })
    City findByName(@Param("cityName") String cityName);
}

