package com.wyatt.springboot_demo.service;

import com.wyatt.springboot_demo.bean.City;

import java.util.List;

/**
 * Created by ASUS on 2019/4/21.
 */
public interface CityService {

    /**
     * 获取城市信息列表
     */
    List<City> findAllCity();

    /**
     * 根据城市id查询城市信息
     */
    City findCityById(Long id);

    /**
     * 新增城市信息
     */
    Long addCity(City city);

    /**
     * 更新城市信息
     */
    Long updateCity(City city);

    /**
     * 根据id删除城市信息
     */
    Long deleteCity(Long id);
}
