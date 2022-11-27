@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.HseCommunityEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 小区信息 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IHseCommunityMapper : IMapper<HseCommunityEntity>
