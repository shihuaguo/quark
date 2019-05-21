package com.github.quark.mongo.service.impl;

import com.github.quark.mongo.model.Person;
import com.github.quark.mongo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @author shihuaguo
 * @email huaguoshi@gmail.com
 * @date 2019-05-21
 **/
@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    private final ReactiveMongoTemplate mt;

    @Autowired
    public UserServiceImpl(ReactiveMongoTemplate mongoTemplate) {
        this.mt = mongoTemplate;
    }

    @Override
    public Flux<Person> findAll() {
        return mt.findAll(Person.class);
    }

    @Override
    public Flux<Person> queryByName(String name) {
        Query query = query(where("name").is(name));
        return mt.find(query, Person.class);
    }

    @Override
    public Mono<Person> save(Person person) {
        return mt.insert(person);
    }
}
