package com.lin.dao;

import com.lin.pojo.People;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PeopleMapper {
    List<People> getAllPeople();
}
