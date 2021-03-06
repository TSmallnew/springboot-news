package com.puboot.module.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.puboot.module.admin.model.BizArticleTags;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface BizArticleTagsService extends IService<BizArticleTags> {


    /**
     * 通过文章id删除文章-标签关联数据
     *
     * @param articleId
     * @return
     */
    int removeByArticleId(Integer articleId);

    /**
     * 批量添加
     *
     * @param tagIds
     * @param articleId
     */
    void insertList(Integer[] tagIds, Integer articleId);
}
