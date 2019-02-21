package properties;

/**
 * Created by 吴猛
 * Date:2019/2/21
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

    public static final String GLOBAL_SOURCES = "/static/**";
}
