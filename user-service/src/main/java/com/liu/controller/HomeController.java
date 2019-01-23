package com.liu.controller;

import com.liu.model.User;
import com.liu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home/{id}")
    @ResponseBody
    public User home(@PathVariable("id") Long id){
       User user=userService.queryById(id);
       return user;
    }
}
