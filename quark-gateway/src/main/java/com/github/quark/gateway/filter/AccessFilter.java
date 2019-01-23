package com.github.quark.gateway.filter;

/**
 * @author shihuaguo
 * @email huaguoshi@gmail.com
 * @date 2018-10-24
 **/
//public class AccessFilter extends ZuulFilter {
//    @Override
//    public String filterType() {
//        return FilterConstants.PRE_TYPE;
//    }
//
//    @Override
//    public int filterOrder() {
//        return FORM_BODY_WRAPPER_FILTER_ORDER - 1;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() throws ZuulException {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        ctx.set("startTime", System.currentTimeMillis());
//        HttpServletRequest req = ctx.getRequest();
//        System.out.println(req.getParameterMap());
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            RequestContext requestContext = RequestContext.getCurrentContext();
//            requestContext.addZuulRequestHeader(SecurityConstants.USER_HEADER, authentication.getName());
//            requestContext.addZuulRequestHeader(SecurityConstants.ROLE_HEADER,  StringUtils.join(authentication.getAuthorities().iterator(), ","));
//        }
//        return null;
//    }
//}
