package com.puboot.module.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.puboot.module.admin.model.BizArticle;
import com.puboot.module.admin.vo.ArticleConditionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface BizArticleMapper extends BaseMapper<BizArticle> {

    /**
     * 分页查询，关联查询文章标签、文章类型
     *
     * @param page
     * @param vo
     * @return
     */
    List<BizArticle> findByCondition(@Param("page") IPage<BizArticle> page, @Param("vo") ArticleConditionVo vo);

    /**
     * 统计指定文章的标签集合
     *
     * @param list
     * @return
     */
    List<BizArticle> listTagsByArticleId(List<Integer> list);

    /**
     * 热门文章
     *
     * @param page
     * @return
     */
    List<BizArticle> hotList(@Param("page") IPage<BizArticle> page);

    /**
     * 获取文章详情，文章标签、文章类型
     *
     * @param id
     * @return
     */
    BizArticle getById(Integer id);

    /**
     * 批量删除文章
     *
     * @param ids
     * @return
     */
    int deleteBatch(Integer[] ids);

}
