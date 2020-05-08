package com.puboot.module.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.puboot.module.admin.model.BizCategory;

import java.util.List;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface BizCategoryMapper extends BaseMapper<BizCategory> {

    List<BizCategory> selectCategories(BizCategory bizCategory);

    int deleteBatch(Integer[] ids);

    BizCategory getById(Integer id);
}
