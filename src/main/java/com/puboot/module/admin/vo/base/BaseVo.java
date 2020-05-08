package com.puboot.module.admin.vo.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 * @version V1.0
 * @date
 */
@Data
public abstract class BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;

    private Date createTime;
    private Date updateTime;

}