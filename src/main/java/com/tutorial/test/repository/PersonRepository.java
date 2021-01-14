package com.tutorial.test.repository;

import com.tutorial.test.data.Person;

public interface PersonRepository {

    Person selectById(String id);
}
