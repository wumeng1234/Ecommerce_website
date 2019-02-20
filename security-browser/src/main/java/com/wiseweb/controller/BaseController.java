package com.wiseweb.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * Created by 吴猛
 * Date:2019/2/19
 */
@RequestMapping("/base")
@Controller
public class BaseController {

    //登陆页
    @RequestMapping("/login")
    public String login(){
        return "login";
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
