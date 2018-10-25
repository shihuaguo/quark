package com.github.openstore.service.admin.service.impl;

import com.github.openstore.common.constant.SecurityConstants;
import com.github.openstore.service.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author shihuaguo
 * @email huaguoshi@gmail.com
 * @date 2018-10-24
 **/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public void saveImageCode(String randomStr, String imageCode) {
        redisTemplate.opsForValue().set(SecurityConstants.DEFAULT_CODE_KEY + randomStr, imageCode, SecurityConstants.DEFAULT_IMAGE_EXPIRE, TimeUnit.SECONDS);
    }
}
