package com.liu.model;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name="tb_user")
@Data
public class User implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
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