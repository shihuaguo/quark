package com.github.quark.gateway;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableZuulProxy
//@EnableFeignClients
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
//@ComponentScan(basePackages = {"com.github.quark.gateway"})
@EnableApolloConfig
public class QuarkGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuarkGatewayApplication.class, args);
    }
//    @Bean
//    LoadBalancerInterceptor loadBalancerInterceptor(LoadBalancerClient loadBalance){
//        return new LoadBalancerInterceptor(loadBalance);
//    }
//
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

//    @Bean
//    public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(DiscoveryClient discoveryClient) {
//        return new DiscoveryClientRouteDefinitionLocator(discoveryClient);
//    }
}
