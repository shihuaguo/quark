package com.github.quark.mongo.controller;

import com.github.quark.common.core.model.ICode;
import com.github.quark.common.core.model.R;
import com.github.quark.common.core.validator.AddGroup;
import com.github.quark.common.core.validator.ParamValidator;
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
    public Flux<Person> findAll() {
        return userService.findAll();
    }

    @GetMapping("/queryByName")
    public Flux<Person> queryByName(String name) {
        return userService.queryByName(name);
    }

    @PostMapping("/save")
    public Mono<R<?>> save(@RequestBody Person person) {
        //验证参数
        R<Person> r = ParamValidator.validate(person, AddGroup.class);
        if (r.isFailed()) {
            return Mono.just(r);
        }
        Flux<Person> flux = userService.queryByName(person.getName());
        return flux.count().flatMap(c -> c > 0 ?
                Mono.just(R.fail(ICode.REQUEST_PARAM_ILLEGAL.getCode(), "username already exists!")) :
                userService.save(person).map(p -> R.success()));
    }
}
