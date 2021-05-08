package org.github.base.service.impl;

import org.github.base.entity.VisitorEntity;
import org.github.base.mapper.IVisitorMapper;
import org.github.base.service.IVisitorService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-08
 */
@Service
public class VisitorServiceImpl extends ServiceImpl<IVisitorMapper, VisitorEntity> implements IVisitorService {}
