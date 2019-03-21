package com.github.quark.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
//@EnableApolloConfig
public class QuarkEurekeServer {

    public static void main(String[] args) {
        SpringApplication.run(QuarkEurekeServer.class, args);
    }
}
