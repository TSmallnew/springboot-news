package com.puboot.module.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.puboot.module.admin.mapper.BizLoveMapper;
import com.puboot.module.admin.model.BizLove;
import com.puboot.module.admin.service.BizLoveService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author
 * @version V1.0
 * @date
 */
@Service
@AllArgsConstructor
public class BizLoveServiceImpl extends ServiceImpl<BizLoveMapper, BizLove> implements BizLoveService {

    private final BizLoveMapper loveMapper;

    @Override
    public BizLove checkLove(Integer bizId, String userIp) {
        return loveMapper.checkLove(bizId, userIp);
    }
}
