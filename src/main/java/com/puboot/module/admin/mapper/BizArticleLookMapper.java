package com.puboot.module.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.puboot.module.admin.model.BizArticleLook;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface BizArticleLookMapper extends BaseMapper<BizArticleLook> {

    int checkArticleLook(@Param("articleId") Integer articleId, @Param("userIp") String userIp, @Param("lookTime") Date lookTime);
}
