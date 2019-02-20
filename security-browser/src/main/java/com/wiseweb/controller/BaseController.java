package com.wiseweb.controller;
import com.wiseweb.dao.UserDao;
import com.wiseweb.entity.User;
import com.wiseweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by 吴猛
 * Date:2019/2/19
 */
@RequestMapping("/base")
@Controller
public class BaseController {
    @Autowired
    private UserService userService;
    //登陆页
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public List<User> getUser(){
        List<User> users = userService.getUsers();
        return users;
    }

    @RequestMapping("/add")
    @ResponseBody
    public boolean addUser(){
        User user = new User("范冰冰","123456","女","30","18745611233","524545@.com");
        userService.addUser(user);
        return true;
    }
    //主页
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name","吴猛");
        return "pages/index";
    }

    /**
     * 产品介绍
     */
    @RequestMapping("/description")
    public String description(){
        return "pages/product-description";
    }

    /**
     * 筛选页
     */
    @RequestMapping("/screening")
    public String screening(){
        return "pages/product-screening";
    }
}
