package com.github.quark.mongo.controller;

import com.github.quark.mongo.model.Person;
import com.github.quark.mongo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author shihuaguo
 * @email huaguoshi@gmail.com
 * @date 2019-05-21
 **/
@RestController
@RequestMapping("person")
@Slf4j
public class PersonController {

    private final IUserService userService;

    @Autowired
    public PersonController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public Flux<Person> findAll(){
        return userService.findAll();
    }

    @GetMapping("/queryByName")
    public Flux<Person> queryByName(String name){
        return userService.queryByName(name);
    }

    @PostMapping("/save")
    public Mono<String> save(@RequestBody Person person){
        return userService.save(person).map(Person::getId);
    }
}
