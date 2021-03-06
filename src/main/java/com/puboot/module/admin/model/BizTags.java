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
public class BizTags extends BaseVo {
    private static final long serialVersionUID = 3578477956306175100L;

    private String name;
    private String description;

}
