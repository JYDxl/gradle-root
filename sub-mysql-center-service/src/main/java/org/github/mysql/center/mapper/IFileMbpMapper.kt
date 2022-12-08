@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.mapper;

import org.github.mysql.center.entity.FileMbpPo;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 * 文件 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IFileMbpMapper : IMapper<FileMbpPo>
