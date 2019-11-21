package org.github.base.service.impl;

import org.github.base.entity.GenTableEntity;
import org.github.base.mapper.IGenTableMapper;
import org.github.base.service.IGenTableService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 代码生成业务表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-21
 */
@Service
public class GenTableServiceImpl extends ServiceImpl<IGenTableMapper, GenTableEntity> implements IGenTableService {}
