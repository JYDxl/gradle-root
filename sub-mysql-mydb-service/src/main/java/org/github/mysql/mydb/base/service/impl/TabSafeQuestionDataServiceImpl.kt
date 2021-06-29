@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.service.impl;

import org.github.mysql.mydb.base.entity.TabSafeQuestionDataEntity;
import org.github.mysql.mydb.base.mapper.ITabSafeQuestionDataMapper;
import org.github.mysql.mydb.base.service.ITabSafeQuestionDataService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 安全问题数据项表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class TabSafeQuestionDataServiceImpl : ServiceImpl<ITabSafeQuestionDataMapper, TabSafeQuestionDataEntity>(), ITabSafeQuestionDataService
