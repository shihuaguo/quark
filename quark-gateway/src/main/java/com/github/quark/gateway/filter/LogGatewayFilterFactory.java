package com.github.quark.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * @author shihuaguo
 * @email huaguoshi@gmail.com
 * @date 2019-05-21
 **/
@Component
@Slf4j
public class LogGatewayFilterFactory extends AbstractGatewayFilterFactory<LogGatewayFilterFactory.Config> {
    public LogGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(LogGatewayFilterFactory.Config config) {
        return ((exchange, chain) -> {
            log.info("LogGatewayFilterFactory,request uri={}", exchange.getRequest().getURI().getRawPath());
            return chain.filter(exchange);
        });
    }

    public static class Config {
    }
}
