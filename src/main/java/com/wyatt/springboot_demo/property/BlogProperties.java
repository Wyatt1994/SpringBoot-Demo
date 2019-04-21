package com.wyatt.springboot_demo.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * Created by ASUS on 2019/4/18.
 */

@Component
public class BlogProperties {

    @Value("${com.wyatt.blog.name}")
    private String name;

    @Value("${com.wyatt.blog.title}")
    private String title;

    @Value("${com.wyatt.blog.desc")
    private String desc;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
