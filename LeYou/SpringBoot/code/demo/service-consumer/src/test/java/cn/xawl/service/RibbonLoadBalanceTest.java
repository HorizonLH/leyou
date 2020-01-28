package cn.xawl.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author hhl
 * @date - 21:02
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RibbonLoadBalanceTest {


    @Autowired
    private RibbonLoadBalancerClient client;
    @Test
    public void test(){

        for (int i = 0; i < 50; i++) {
            ServiceInstance instance = this.client.choose("service-provide");
            System.out.println(instance.getHost() + ":" + instance.getPort());
        }
    }
}
