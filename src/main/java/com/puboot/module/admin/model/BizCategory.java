package com.puboot.module.admin.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.puboot.module.admin.vo.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author
 * @version V1.0
 * @date
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizCategory extends BaseVo {
    private static final long serialVersionUID = -3409570480708571338L;

    private Integer pid;
    private String name;
    private String description;
    private Integer sort;
    private Integer status;
    private String icon;


    @TableField(exist = false)
    private BizCategory parent;
    @TableField(exist = false)
    private List<BizCategory> nodes;

}
