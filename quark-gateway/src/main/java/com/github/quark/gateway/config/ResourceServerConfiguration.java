package com.github.quark.gateway.config;

/**
 * @author shihuaguo
 * @email huaguoshi@gmail.com
 * @date 2018-10-25
 **/
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//    @Autowired
//    private FilterIgnorePropertiesConfig filterIgnorePropertiesConfig;
//    @Autowired
//    private OAuth2WebSecurityExpressionHandler expressionHandler;
//    @Autowired
//    private AccessDeniedHandler accessDeniedHandler;
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        //允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
//        http.headers().frameOptions().disable();
//        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
//                .authorizeRequests();
//        filterIgnorePropertiesConfig.getUrls().forEach(url -> registry.antMatchers(url).permitAll());
//        registry.anyRequest()
//                .access("@permissionService.hasPermission(request,authentication)");
//    }
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) {
//        resources.expressionHandler(expressionHandler);
//        resources.accessDeniedHandler(accessDeniedHandler);
//    }
//
//    /**
//     * 配置解决 spring-security-oauth问题
//     * https://github.com/spring-projects/spring-security-oauth/issues/730
//     *
//     * @param applicationContext ApplicationContext
//     * @return OAuth2WebSecurityExpressionHandler
//     */
//    @Bean
//    public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
//        OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
//        expressionHandler.setApplicationContext(applicationContext);
//        return expressionHandler;
//    }
//
//    /**
//     * 加密方式
//     * @return
//     */
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//}