package com.puboot.module.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.puboot.module.admin.model.BizLink;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface BizLinkMapper extends BaseMapper<BizLink> {

    List<BizLink> selectLinks(@Param("page") IPage<BizLink> page, @Param("bizLink") BizLink bizLink);

    int deleteBatch(Integer[] ids);

}
