package com.puboot.module.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.puboot.module.admin.model.BizComment;
import com.puboot.module.admin.vo.CommentConditionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface BizCommentMapper extends BaseMapper<BizComment> {

    /**
     * 分页查询
     *
     * @param page
     * @param vo
     * @return
     */
    List<BizComment> selectComments(@Param("page") IPage<BizComment> page, @Param("vo") CommentConditionVo vo);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteBatch(Integer[] ids);
}
