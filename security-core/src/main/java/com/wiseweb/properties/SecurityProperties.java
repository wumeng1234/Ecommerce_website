package com.wiseweb.properties;/**
 * Created by 吴猛
 * Date:2019/2/22
 */
public interface SecurityProperties {
    /**
     * 默认无权限时跳转的页面
     */
    public static final String DEFAULT_LOGIN_URL = "/base/login";
    /**
     * 表单登陆处理的url
     */
    public static final String DEFAULT_LOGIN_FORM = "/login";

    /**
     * 页面静态资源位置
     */
    public static final String GLOBAL_SOURCES = "/static/**";
    /**
     * 主页请求不拦截
     */
    public static final String DEFAULT_INDEX_PAGE = "/index";
}
