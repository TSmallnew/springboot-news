package com.puboot.module.admin.model;

import com.puboot.module.admin.vo.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author
 * @version V1.0
 * @date
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizTheme extends BaseVo {
    private static final long serialVersionUID = -1364438867316136662L;

    private String name;

    private String description;

    private String img;

    private Integer status;

}