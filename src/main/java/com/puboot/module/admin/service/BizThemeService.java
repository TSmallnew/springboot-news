package com.puboot.module.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.puboot.module.admin.model.BizTheme;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface BizThemeService extends IService<BizTheme> {

    int useTheme(Integer id);

    BizTheme selectCurrent();

    int deleteBatch(Integer[] ids);

}
