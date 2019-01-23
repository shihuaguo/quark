package com.github.quark.gateway.handler;

/**
 * @author shihuaguo
 * @email huaguoshi@gmail.com
 * @date 2018-10-25
 **/
//@Slf4j
//@Component
//public class AccessDeniedHandler extends OAuth2AccessDeniedHandler {
//    private final ObjectMapper objectMapper;
//
//    @Autowired
//    public AccessDeniedHandler(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//
//    /**
//     * 授权拒绝处理，使用R包装
//     *
//     * @param request       request
//     * @param response      response
//     * @param authException authException
//     * @throws IOException      IOException
//     * @throws ServletException ServletException
//     */
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
//        log.info("授权失败，禁止访问 {}", request.getRequestURI());
//        response.setCharacterEncoding(CommonConstant.UTF8);
//        response.setContentType(CommonConstant.CONTENT_TYPE);
//        R<String> result = new R<>(new DeniedException("授权失败，禁止访问"));
//        response.setStatus(HttpStatus.SC_FORBIDDEN);
//        PrintWriter printWriter = response.getWriter();
//        printWriter.append(objectMapper.writeValueAsString(result));
//    }
//}
