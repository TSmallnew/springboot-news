package com.puboot.module.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.puboot.module.admin.model.BizArticleLook;

import java.util.Date;

/**
 * @author
 * @version V1.0
 * @date
 */
public interface BizArticleLookService extends IService<BizArticleLook> {

    int checkArticleLook(Integer articleId, String userIp, Date lookTime);
}
