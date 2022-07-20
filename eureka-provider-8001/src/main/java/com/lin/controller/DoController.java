package com.lin.controller;

import com.lin.server.DoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DoController {
    @Value("${server.port}")
    private Integer port;

    @Autowired
    private DoServiceImpl doService;

    @GetMapping("/do1")
    @ResponseBody
    public String do1() throws InterruptedException {
        return doService.do1()+port+"端口";
    }

    @GetMapping("/do2")
    @ResponseBody
    public String do2() {
        return "我是do2"+port+"端口";
    }

    @GetMapping("/do3")
    @ResponseBody
    public String do3() {
        return "我是do3"+port+"端口";
    }
}
