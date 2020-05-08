package com.puboot.module.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.puboot.module.admin.model.BizTheme;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface BizThemeMapper extends BaseMapper<BizTheme> {

    int setInvaid();

    int updateStatusById(Integer id);

    int deleteBatch(Integer[] ids);
}