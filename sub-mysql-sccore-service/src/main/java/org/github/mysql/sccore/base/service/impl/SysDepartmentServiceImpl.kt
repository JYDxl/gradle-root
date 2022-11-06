@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysDepartmentEntity;
import org.github.mysql.sccore.base.mapper.ISysDepartmentMapper;
import org.github.mysql.sccore.base.service.ISysDepartmentService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 部门表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysDepartmentServiceImpl : ServiceImpl<ISysDepartmentMapper, SysDepartmentEntity>(), ISysDepartmentService
