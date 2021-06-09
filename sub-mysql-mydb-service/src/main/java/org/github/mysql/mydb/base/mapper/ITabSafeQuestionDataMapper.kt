@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.mapper;

import org.github.mysql.mydb.base.entity.TabSafeQuestionDataEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 安全问题数据项表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ITabSafeQuestionDataMapper : IMapper<TabSafeQuestionDataEntity>
