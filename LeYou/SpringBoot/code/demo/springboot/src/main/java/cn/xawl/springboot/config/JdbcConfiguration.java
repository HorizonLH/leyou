package cn.xawl.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author hhl
 * @date - 23:01
 */
@EnableConfigurationProperties(JdbcProperties.class)//明确指定需要用哪个实体类来装载配置信息
@Configuration//声明一个类是一个Java配置类，相当于一个xml配置文件
//@PropertySource("classpath:jdbc.properties")//读取资源文件
public class JdbcConfiguration {

   /* @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;*/

   //@Autowired
   //private JdbcProperties jdbcProperties;

    /*public JdbcConfiguration (JdbcProperties jdbcProperties) {
        this.jdbcProperties = jdbcProperties;
    }*/

    /*@Bean//把方法的返回值注入到spring容器
    public DataSource dataSource(){

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcProperties.getDriverClassName());
        dataSource.setUrl(jdbcProperties.getUrl());
        dataSource.setUsername(jdbcProperties.getUsername());
        dataSource.setPassword(jdbcProperties.getPassword());

        return dataSource;
    }*/

    @Bean//把方法的返回值注入到spring容器
    @ConfigurationProperties(value = "jdbc")
    public DataSource dataSource(){

        DruidDataSource dataSource = new DruidDataSource();

        return dataSource;
    }

}
