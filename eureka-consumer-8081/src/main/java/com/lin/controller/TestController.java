package com.lin.controller;

import com.lin.pojo.People;
import com.lin.server.ProviderServer;
import com.lin.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TestService testService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/doGet")
    @ResponseBody
    public List<People> doGet() {
//        String url = "http://PROVIDER";
//        return restTemplate.getForObject(url+"/test", List.class);
        return testService.getInfo();
    }

    @GetMapping("/do1")
    @ResponseBody
    public String do1() {
        return testService.do1();
    }

    @GetMapping("/do2/{a}")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "handler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "20000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String do2(int a) {
        int b = 1/a;
        return testService.do2();
    }

    public String handler(int a) {
        return "我是处理方法";
    }

    @GetMapping("/do3")
    @ResponseBody
    public String do3() {
        return testService.do3();
    }

    @GetMapping("/discovery")
    @ResponseBody
    public Map<String, Object> discovery() {
        Map<String, Object> map = new HashMap<>();
        List<String> services = discoveryClient.getServices();
        map.put("services", services);
        return map;
    }
}
