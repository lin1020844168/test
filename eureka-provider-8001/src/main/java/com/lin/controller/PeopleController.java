package com.lin.controller;

import com.lin.pojo.People;
import com.lin.server.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @RequestMapping("/test")
    @ResponseBody
    public List<People> test() throws InterruptedException {
        Thread.sleep(3000);
        return peopleService.getAllPeoples();
    }
}
