@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.mapper;

import org.github.mysql.mydb.base.entity.TabSafeQuestionTypeEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 安全问题类别表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ITabSafeQuestionTypeMapper : IMapper<TabSafeQuestionTypeEntity>