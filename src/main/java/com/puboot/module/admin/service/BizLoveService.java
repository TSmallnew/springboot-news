package com.puboot.module.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.puboot.module.admin.model.BizLove;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface BizLoveService extends IService<BizLove> {

    BizLove checkLove(Integer bizId, String userIp);
}
