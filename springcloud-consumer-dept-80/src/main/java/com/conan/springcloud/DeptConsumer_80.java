package com.conan.springcloud;

import com.conan.myrule.ConanRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

// ribbon eruka 客户端可以直接调用方法
@EnableEurekaClient
@SpringBootApplication
// 在微服务启动的时候,就能加载自定义的ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = ConanRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }
}
