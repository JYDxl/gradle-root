@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.TabSafeQuestionTypeEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 安全问题类别 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ITabSafeQuestionTypeMapper : IMapper<TabSafeQuestionTypeEntity>
