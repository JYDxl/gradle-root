package org.github.base.service.impl;

import org.github.base.entity.SysDictDataEntity;
import org.github.base.mapper.ISysDictDataMapper;
import org.github.base.service.ISysDictDataService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-21
 */
@Service
public class SysDictDataServiceImpl extends ServiceImpl<ISysDictDataMapper, SysDictDataEntity> implements ISysDictDataService {}
