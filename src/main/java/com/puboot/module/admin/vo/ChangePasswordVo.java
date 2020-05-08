package com.puboot.module.admin.vo;

import lombok.Data;

/**
 * @author
 * @version V1.0
 * @date
 */
@Data
public class ChangePasswordVo {

    String oldPassword;
    String newPassword;
    String confirmNewPassword;

}
