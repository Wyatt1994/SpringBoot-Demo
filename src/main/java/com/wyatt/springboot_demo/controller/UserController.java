package com.wyatt.springboot_demo.controller;

import com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember;
import com.wyatt.springboot_demo.bean.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ASUS on 2019/4/21.
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

    //保证线程安全的map
    static Map<Long,User> users = new ConcurrentHashMap<>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> list = new ArrayList<>(users.values());
        return list;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        //也可以使用@RequestParam注解传递参数,前提是request域map中有user这个参数名
        users.put(user.getId(),user);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        return users.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable Long id, @ModelAttribute User user){
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id,u);
        return "success";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "success";
    }
}
