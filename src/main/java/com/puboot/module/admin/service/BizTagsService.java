package com.puboot.module.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.puboot.module.admin.model.BizTags;

import java.util.List;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface BizTagsService extends IService<BizTags> {

    List<BizTags> selectTags(BizTags bizTags);

    IPage<BizTags> pageTags(BizTags bizTags, Integer pageNumber, Integer pageSize);

    int deleteBatch(Integer[] ids);
}
