package com.he.controller;

import com.he.client.UserClient;
import com.he.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
//@DefaultProperties(defaultFallback = "queryByIdFallback")
public class controller {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

   /* @Autowired
    private DiscoveryClient  discoveryClient;

    @Autowired
    private RibbonLoadBalancerClient client;
*/
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id){
        return userClient.queryById(id);
    }

    /*@GetMapping("/{id}")
    //@HystrixCommand(fallbackMethod = "queryByIdFallback")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String queryById(@PathVariable("id") Long id){
        if (id%2==0){
            throw new RuntimeException("");
        }
        String url="http://user-service/index/home/"+id;
        String user=restTemplate.getForObject(url,String.class);
        return user;
    }*/

    public String queryByIdFallback(){
        return "不好意思，服务器太拥挤了!";
    }


    /*@GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id){
       //根据服务ID获取实例
        //List<ServiceInstance> instances=discoveryClient.getInstances("user-service");
        //ServiceInstance instance=client.choose("user-service");

        //ServiceInstance instance=instances.get(0);
        //String url="http://"+instance.getHost()+":"+instance.getPort()+"/index/home/"+id;
        String url="http://user-service/index/home/"+id;
        User user=restTemplate.getForObject(url,User.class);
        return user;
    }*/

}
