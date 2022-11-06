@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.mapper;

import org.github.mysql.sccore.base.entity.SysImportConfigEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 导入出配置表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysImportConfigMapper : IMapper<SysImportConfigEntity>
