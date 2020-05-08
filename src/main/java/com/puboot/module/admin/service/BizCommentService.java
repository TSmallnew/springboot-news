package com.puboot.module.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.puboot.module.admin.model.BizComment;
import com.puboot.module.admin.vo.CommentConditionVo;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface BizCommentService extends IService<BizComment> {

    IPage<BizComment> selectComments(CommentConditionVo vo, Integer pageNumber, Integer pageSize);

    int deleteBatch(Integer[] ids);

}
