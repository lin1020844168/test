package com.lin.server;

import com.lin.pojo.People;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProviderFallback implements ProviderServer {
    @Override
    public List<People> getInfo() {
        return null;
    }

    @Override
    public String do1() {
        return "do1执行失败了";
    }

    @Override
    public String do2() {
        return "do2执行失败了";
    }


    @Override
    public String do3() {
        return "do3执行失败了";
    }
}
