@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.mapper;

import org.github.mysql.center.base.entity.FileMbpEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 文件 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IFileMbpMapper : IMapper<FileMbpEntity>
