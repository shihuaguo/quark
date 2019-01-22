package com.github.openstore.service.admin.service;

public interface SysUserService {
    /**
     * 保存验证码
     * @param randomStr
     * @param text
     */
    void saveImageCode(String randomStr, String text);
}
