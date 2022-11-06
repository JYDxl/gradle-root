@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysClientFsRelationEntity;
import org.github.mysql.sccore.base.mapper.ISysClientFsRelationMapper;
import org.github.mysql.sccore.base.service.ISysClientFsRelationService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 客户端的文件存储方式和空间大小限制，1：文件服务，3：数据库 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysClientFsRelationServiceImpl : ServiceImpl<ISysClientFsRelationMapper, SysClientFsRelationEntity>(), ISysClientFsRelationService
