package com.wiseweb;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by 吴猛
 * Date:2019/2/19
 */
@SpringBootApplication
@MapperScan("com.wiseweb.dao")
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class,args);
    }
}
