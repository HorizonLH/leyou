package cn.xawl.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.xawl.service.mapper")//mapper接口的包扫描
//@EnableEurekaClient  也可以使用 由netflix提供
@EnableDiscoveryClient//通常使用这个，启用eureka客户端，是由springCloudCore 所提供
public class ServiceProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProvideApplication.class, args);
    }

}
