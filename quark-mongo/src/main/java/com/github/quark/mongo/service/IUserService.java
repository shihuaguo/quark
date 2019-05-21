package com.github.quark.mongo.service;

import com.github.quark.mongo.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author shihuaguo
 * @email huaguoshi@gmail.com
 * @date 2019-05-21
 **/
public interface IUserService {

    Flux<Person> findAll();

    Flux<Person> queryByName(String name);

    Mono<Person> save(Person person);
}
