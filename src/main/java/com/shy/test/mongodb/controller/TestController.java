package com.shy.test.mongodb.controller;

import com.shy.test.mongodb.entity.TestEntity;
import com.shy.test.mongodb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("getById")
    public Object getById(String id){
        return testService.getObjectById(id);
    }

    @RequestMapping("getByName")
    public Object getByName(String name){
        return testService.getObjectByName(name);
    }

    @RequestMapping("save")
    public Object save(String name,String id){
        TestEntity testEntity = new TestEntity();
        testEntity.setId(id);
        testEntity.setName(name);
        return testService.save(testEntity);
    }

    @RequestMapping("delete")
    public Object remove(String id){
        return testService.remove(id);
    }

    @RequestMapping("update")
    public Object remove(String id,String name){
        TestEntity testEntity = new TestEntity();
        testEntity.setId(id);
        testEntity.setName(name);
        return testService.update(testEntity);
    }
}
