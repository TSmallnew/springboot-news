package com.puboot.module.admin.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author
 * @version V1.0
 * @date
 */
@Data
public class UserRole implements Serializable {

    private static final long serialVersionUID = 2455220013366482894L;

    private Integer id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 角色id
     */
    private String roleId;

}