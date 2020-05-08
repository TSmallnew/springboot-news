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
public class BizLink extends BaseVo {
    private static final long serialVersionUID = -6511423333796987519L;

    private String url;
    private String name;
    private String description;
    private String img;
    private String email;
    private String qq;
    private Integer status;
    private Integer origin;
    private String remark;

}
