package com.puboot.module.admin.vo.base;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author
 * @version V1.0
 * @date
 */
@Data
@AllArgsConstructor
public class PageResultVo {
    private List rows;
    private Long total;

}
