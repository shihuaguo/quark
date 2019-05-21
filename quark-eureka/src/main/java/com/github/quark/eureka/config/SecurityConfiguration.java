package com.github.quark.eureka.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Slf4j
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * 配置安全信息
     * - 禁用csrf攻击功能
     * - 开启所有请求需要验证并且使用http basic进行认证
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("SecurityConfiguration-------------配置启动--------{}-",http);
        http.csrf()
                .disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}