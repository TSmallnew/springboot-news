package com.puboot.module.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.puboot.module.admin.model.BizCategory;

import java.util.List;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface BizCategoryService extends IService<BizCategory> {

    List<BizCategory> selectCategories(BizCategory bizCategory);

    int deleteBatch(Integer[] ids);

    BizCategory selectById(Integer id);

    List<BizCategory> selectByPid(Integer pid);

}
