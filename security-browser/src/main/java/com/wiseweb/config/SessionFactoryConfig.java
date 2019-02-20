package com.wiseweb.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by 吴猛
 * Date：2019/2/20
 */
@Configuration
public class SessionFactoryConfig {
    private static final String mybatisConfigPath = "mybatis-config.xml";
    private static final String mapperPath = "/mapper/**.xml";
    private static final String entityPackages = "com.wiseweb.entity";

    @Autowired
    private DataSource dataSource;

    @Bean(name = "sessionFactory")
    public SqlSessionFactoryBean creatSessionFactory() throws IOException {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        //设置mybatis配置文件位置
        sessionFactory.setConfigLocation(new ClassPathResource(mybatisConfigPath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String mapperLocation= PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        //设置mapper文件位置
        sessionFactory.setMapperLocations(resolver.getResources(mapperLocation));
        //设置entity包位置
        sessionFactory.setTypeAliasesPackage(entityPackages);
        return sessionFactory;
    }
}
