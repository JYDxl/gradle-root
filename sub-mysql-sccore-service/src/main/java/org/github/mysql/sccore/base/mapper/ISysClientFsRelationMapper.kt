@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.mapper;

import org.github.mysql.sccore.base.entity.SysClientFsRelationEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 客户端的文件存储方式和空间大小限制，1：文件服务，3：数据库 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysClientFsRelationMapper : IMapper<SysClientFsRelationEntity>
