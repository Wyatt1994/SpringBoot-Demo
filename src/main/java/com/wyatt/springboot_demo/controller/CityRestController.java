package com.wyatt.springboot_demo.controller;

import com.sun.beans.editors.LongEditor;
import com.wyatt.springboot_demo.bean.City;
import com.wyatt.springboot_demo.service.CityService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ASUS on 2019/4/21.
 */
@RestController
public class CityRestController {

    private static Logger logger = LoggerFactory.getLogger(CityRestController.class);
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") String id){
        Long convertedId = Long.valueOf(id);
        return cityService.findCityById(convertedId);
    }


    @RequestMapping(value = "/city/all", method = RequestMethod.GET)
    public List<City> findAllCity(){
        return cityService.findAllCity();
    }

    //由于设定为json数据，因此必须使用@ResponseBody
    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public Long addCity(@RequestBody City city){
//        logger.info(city.toString());
        return cityService.addCity(city);
    }

    @RequestMapping(value = "/city", method = RequestMethod.PUT)
    public Long updateCity(@RequestBody City city) {
        return cityService.updateCity(city);
    }

    @RequestMapping(value = "/city/{id}", method = RequestMethod.DELETE)
    public Long deleteCity(@PathVariable("id") Long id) {
        return cityService.deleteCity(id);
    }

    //默认转换接收的Date类型
    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));

    }
}
