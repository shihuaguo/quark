package com.github.quark.mongo.component;

import com.github.quark.mongo.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.Lifecycle;
import org.springframework.context.LifecycleProcessor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.concurrent.CountDownLatch;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

/**
 * @author shihuaguo
 * @email huaguoshi@gmail.com
 * @date 2019-05-14
 **/
@Component
@Slf4j
public class MongoOps  {
    @Autowired
    private ReactiveMongoTemplate mongoTemplate;

    @PostConstruct
    public void init(){
        new Thread(() -> {
            try {
                init0();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void init0() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        mongoTemplate.insert(new Person("monday", 30))
                .doOnNext(person -> log.info("insert:{}", person))
                .flatMap(person -> mongoTemplate.findById(person.getId(), Person.class))
                .doOnNext(person -> log.info("found: " + person))
                .zipWith(mongoTemplate.updateFirst(query(where("name").is("monday")), update("age", 40), Person.class))
                .flatMap(tuple -> mongoTemplate.remove(tuple.getT1()))
                .flatMapMany(dr -> mongoTemplate.findAll(Person.class))
                .count().doOnSuccess(count -> {
                    log.info("Number of people: " + count);
                    latch.countDown();
                }).subscribe(t -> latch.countDown());
        log.info("Count Down latch await...");
        latch.await();
        log.info("Count Down latch await finish");
    }
}
