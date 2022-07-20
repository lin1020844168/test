package com.lin.server;

import com.lin.dao.PeopleMapper;
import com.lin.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    public List<People> getAllPeoples() {
        return peopleMapper.getAllPeople();
    }
}
