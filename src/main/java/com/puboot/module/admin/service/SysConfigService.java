package com.puboot.module.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.puboot.module.admin.model.SysConfig;

import java.util.Map;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface SysConfigService extends IService<SysConfig> {

    Map<String, String> selectAll();

    boolean updateByKey(String key, String value);
}
