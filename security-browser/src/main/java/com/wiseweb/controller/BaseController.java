package com.wiseweb.controller;

import com.wiseweb.entity.User;
import com.wiseweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wiseweb.properties.SecurityProperties;


import java.util.List;

/**
 * Created by 吴猛
 * Date:2019/2/19
 */
@Controller
public class BaseController {


    @Autowired
    private UserService userService;

    //登陆页,默认无权限时跳转的页面
    @RequestMapping(SecurityProperties.DEFAULT_LOGIN_URL)
    public String login() {
        return "base/login";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public List<User> getUser() {
        List<User> users = userService.getUsers();
        return users;
    }

    @RequestMapping("/add")
    @ResponseBody
    public boolean addUser() {
        User user = new User("范冰冰", "123456", "女", "30", "18745611233", "524545@.com");
        userService.addUser(user);
        return true;
    }


    //主页
    @RequestMapping(SecurityProperties.DEFAULT_INDEX_PAGE)
    public String index(Model model) {
        return "pages/index";
    }

    /**
     * 产品介绍
     */
    @RequestMapping("/description")
    public String description() {
        return "pages/product-description";
    }

    /**
     * 筛选页
     */
    @RequestMapping("/screening")
    public String screening() {
        return "pages/product-screening";
    }
}
