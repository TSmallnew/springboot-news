package com.puboot.module.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.puboot.module.admin.model.BizTags;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface BizTagsMapper extends BaseMapper<BizTags> {

    List<BizTags> selectTags(@Param("page") IPage<BizTags> page, @Param("bizTags") BizTags bizTags);

}
