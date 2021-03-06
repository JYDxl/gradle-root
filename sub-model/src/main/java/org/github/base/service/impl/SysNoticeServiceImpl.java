package org.github.base.service.impl;

import org.github.base.entity.SysNoticeEntity;
import org.github.base.mapper.ISysNoticeMapper;
import org.github.base.service.ISysNoticeService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通知公告表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-12-12
 */
@Service
public class SysNoticeServiceImpl extends ServiceImpl<ISysNoticeMapper, SysNoticeEntity> implements ISysNoticeService {}
