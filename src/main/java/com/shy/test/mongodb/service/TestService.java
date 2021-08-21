package com.shy.test.mongodb.service;

import com.shy.test.mongodb.entity.TestEntity;

public interface TestService {


    Object getObjectById(String id);
    Object getObjectByName(String name);
    Object save(TestEntity testEntity);
    Object remove(String id);
    Object update(TestEntity testEntity);

}
