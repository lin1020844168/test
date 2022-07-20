package com.lin.server;

import com.lin.pojo.People;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "PROVIDER", fallback = ProviderFallback.class)
public interface ProviderServer {
    @RequestMapping("/test")
    List<People> getInfo();

    @RequestMapping("/do1")
    String do1();

    @RequestMapping("/do2")
    String do2();

    @RequestMapping("/do3")
    String do3();
}
