package com.april8.Consumer.web;

import com.april8.Consumer.pojo.User;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("consumer")
public class UserController {
    @Resource
    RestTemplate restTemplate;
    @Resource
    DiscoveryClient discoveryClient;
    @GetMapping("{id}")
    public User query(@PathVariable("id") Integer id){
        ServiceInstance instance = discoveryClient.getInstances("user-service").get(0);
        String url = "http://"+ instance.getHost() +":"+ instance.getPort() +"/user/" + id;
        return restTemplate.getForObject(url, User.class);
    }
}