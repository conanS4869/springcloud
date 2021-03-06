package com.conan.springcloud.controller;

import com.conan.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
// 消费者没有service
//    RestTemplate  自己配置一个
    @Autowired
    private RestTemplate restTemplate;

//    private static final String REST_URL_PREFIX = "http://localhost:8001";
// 通过ribbon 这里的地址应该是一个变量,通过服务名来访问
        private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";


    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable Long id) {
//        /dept/get/ 生产者实际的地址
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }
}
