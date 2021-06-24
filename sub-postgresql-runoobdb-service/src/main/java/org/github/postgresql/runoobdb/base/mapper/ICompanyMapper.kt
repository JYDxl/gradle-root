@file:Suppress("RedundantSemicolon")

package org.github.postgresql.runoobdb.base.mapper;

import org.github.postgresql.runoobdb.base.entity.CompanyEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 *  Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ICompanyMapper : IMapper<CompanyEntity>
