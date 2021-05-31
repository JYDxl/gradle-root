@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.TabSafeQuestionDataEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 安全问题库 Mapper 接口
 *
 * @author JYD_XL
 * @since 2021-05-31
 */
@MyBatisMapper
interface ITabSafeQuestionDataMapper : IMapper<TabSafeQuestionDataEntity>
