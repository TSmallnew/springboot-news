package com.puboot.module.admin.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author
 * @version V1.0
 * @date
 */
@Data
public class RolePermission implements Serializable {

    private static final long serialVersionUID = -902800328539403089L;

    private Integer id;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 权限id
     */
    private String permissionId;

}