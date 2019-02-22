package com.wiseweb.entity;
import java.io.Serializable;

/**
 * Created by 吴猛
 * Date：2019/2/20
 */
public class User implements Serializable{
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private String age;
    private String phoneNumber;
    private String email;

    public User() {
    }

    public User(String username, String password, String sex, String age, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
