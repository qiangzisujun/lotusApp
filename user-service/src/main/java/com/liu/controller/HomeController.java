package com.liu.controller;

import com.liu.model.auto.User;
import com.liu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    @ResponseBody
    public String home(){
       User user=userService.getUserById(1);
       return user.toString();
    }
}
