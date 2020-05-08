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
public class BizLove extends BaseVo {
    private static final long serialVersionUID = 6825108677279625433L;

    private Integer bizId;
    private Integer bizType;
    private String userId;
    private String userIp;
    private Integer status;

}
