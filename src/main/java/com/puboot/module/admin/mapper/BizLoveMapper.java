package com.puboot.module.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.puboot.module.admin.model.BizLove;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface BizLoveMapper extends BaseMapper<BizLove> {

    BizLove checkLove(@Param("bizId") Integer bizId, @Param("userIp") String userIp);
}
