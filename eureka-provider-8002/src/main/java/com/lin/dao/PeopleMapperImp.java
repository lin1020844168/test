package com.lin.dao;

import com.lin.pojo.People;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class PeopleMapperImp implements PeopleMapper {

    @Override
    public List<People> getAllPeople() {
        List<People> peoples = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<10; i++) {
            int age = 10+random.nextInt(51);
            String sex = i%2==0?"boy":"girl";
            String name = randomName();
            People people  = new People(age, name, sex);
            peoples.add(people);
        }
        peoples.add(new People(8002, "我是8002端口", "8002"));
        return peoples;
    }

    private String randomName() {
        Random random = new Random();
        String name = "";
        for (int i=0; i<5; i++) {
            name += (char)('a'+random.nextInt(26));
        }
        return name;
    }
}
