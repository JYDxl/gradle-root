@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.WmUserAuthEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 自媒体子账号权限信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IWmUserAuthMapper : IMapper<WmUserAuthEntity>
