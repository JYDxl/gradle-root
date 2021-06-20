@file:Suppress("RedundantSemicolon")

package org.github.mysql.seata.account.base.mapper;

import org.github.mysql.seata.account.base.entity.TAccountEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 账户表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ITAccountMapper : IMapper<TAccountEntity>
