package com.lin.service;

import com.lin.pojo.People;
import com.lin.server.ProviderServer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    public ProviderServer providerServer;

    public String do1() {
        return providerServer.do1();
    }

    public String do2() {
        return providerServer.do2();
    }


    public String do3() {
        return providerServer.do3();
    }

    public List<People> getInfo() {
        return providerServer.getInfo();
    }
}
