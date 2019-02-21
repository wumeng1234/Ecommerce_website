package com.wiseweb.authentication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import properties.SecurityProperties;

/**
 * Created by 吴猛
 * Date:2019/2/21
 * SpringSecurity认证相关
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(SecurityProperties.GLOBAL_SOURCES);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityProperties.DEFAULT_LOGIN_URL)
                .loginProcessingUrl(SecurityProperties.DEFAULT_LOGIN_FORM)
                .and()
                .authorizeRequests()
                .antMatchers(
                        SecurityProperties.DEFAULT_LOGIN_URL
                )
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
