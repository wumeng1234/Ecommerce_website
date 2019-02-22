package com.wiseweb.authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.wiseweb.properties.SecurityProperties;
/**
 * Created by 吴猛
 * Date:2019/2/21
 * SpringSecurity认证相关
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    /**
     *配置静态资源忽略
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/images/**");
        web.ignoring().antMatchers(SecurityProperties.DEFAULT_INDEX_PAGE);
    }

    /**
     * 配置密码加密
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Autowired
    private SuccessHanlder successHanlder;

    @Autowired
    private FaliureHandler faliureHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                //无权限时默认跳转的地址
                .loginPage(SecurityProperties.DEFAULT_LOGIN_URL)
                //登录处理表单请求的url
                .loginProcessingUrl(SecurityProperties.DEFAULT_LOGIN_FORM)
                //登陆成功处理器
                .successHandler(successHanlder)
                .failureHandler(faliureHandler)
                .and()
                //自定义用户认证
                .userDetailsService(userDetailsService)
                .authorizeRequests()
                //默认忽略的地址
                .antMatchers(
                        SecurityProperties.DEFAULT_LOGIN_URL,
                        SecurityProperties.DEFAULT_INDEX_PAGE
                )
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
