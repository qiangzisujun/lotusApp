package com.he.model;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Long id;
    private String userName;
    private String password;
    private String phone;
    private Date created;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", created=" + created +
                '}';
    }
}