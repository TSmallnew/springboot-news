package com.puboot.common.shiro;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

/**
 * js调用 thymeleaf 实现按钮权限
 *
 * @author
 * @version V1.0
 * @date
 */
@Component("perms")
public class PermsService {
    public boolean hasPerm(String permission) {
        return SecurityUtils.getSubject().isPermitted(permission);
    }
}
