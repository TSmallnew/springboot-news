package com.puboot.module.admin.vo.base;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author
 * @version V1.0
 * @date
 */
@Data
@AllArgsConstructor
public class ResponseVo<T> {

    private Integer status;
    private String msg;
    private T data;

    public ResponseVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

}
