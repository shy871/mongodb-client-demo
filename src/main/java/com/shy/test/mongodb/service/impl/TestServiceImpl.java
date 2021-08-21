package com.shy.test.mongodb.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.shy.test.mongodb.entity.TestEntity;
import com.shy.test.mongodb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Object getObjectById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        TestEntity testEntity = mongoTemplate.findOne(query,TestEntity.class,"test01");
        return testEntity;
    }

    @Override
    public Object getObjectByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        TestEntity testEntity = mongoTemplate.findOne(query,TestEntity.class,"test01");
        return testEntity;
    }

    @Override
    public Object save(TestEntity testEntity) {
        TestEntity testEntity1 = mongoTemplate.save(testEntity,"test01");
        return testEntity1;
    }

    @Override
    public Object remove(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        DeleteResult deleteResult = mongoTemplate.remove(query,TestEntity.class,"test01");
        return deleteResult;
    }

    @Override
    public Object update(TestEntity testEntity) {
        Query query = new Query(Criteria.where("id").is(testEntity.getId()));
        Update update = new Update();
        update.set("name", testEntity.getName());
        UpdateResult updateResult = mongoTemplate.updateFirst(query,update,TestEntity.class,"test01");
        return updateResult;
    }
}
