package com.wyatt.springboot_demo.service.impl;

import com.wyatt.springboot_demo.bean.City;
import com.wyatt.springboot_demo.dao.CityDao;
import com.wyatt.springboot_demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2019/4/22.
 */

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityDao cityDao;

    public List<City> findAllCity(){
        return cityDao.findAllCity();
    }
    public City findCityById(Long id) {
        return cityDao.findById(id);
    }

    public Long addCity(City city) {
        return cityDao.saveCity(city);
    }

    public Long updateCity(City city) {
        return cityDao.updateCity(city);
    }

    public Long deleteCity(Long id) {
        return cityDao.deleteCity(id);
    }

}
