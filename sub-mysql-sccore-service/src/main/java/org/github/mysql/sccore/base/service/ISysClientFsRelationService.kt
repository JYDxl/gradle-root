@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service;

import org.github.mysql.sccore.base.entity.SysClientFsRelationEntity;
import org.github.base.IService;

/**
 * 客户端的文件存储方式和空间大小限制，1：文件服务，3：数据库 服务类
 *
 * @author JYD_XL
 */
interface ISysClientFsRelationService : IService<SysClientFsRelationEntity>
