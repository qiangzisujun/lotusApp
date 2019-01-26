package com.he.client;

import com.he.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {

    @Override
    public User queryById(Long id) {
        User user=new User();
        user.setUserName("未查询到用户！");
        return user;
    }
}
