@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.service.impl;

import org.github.mysql.mydb.base.entity.TabSafeQuestionTypeEntity;
import org.github.mysql.mydb.base.mapper.ITabSafeQuestionTypeMapper;
import org.github.mysql.mydb.base.service.ITabSafeQuestionTypeService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 安全问题类别表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class TabSafeQuestionTypeServiceImpl : ServiceImpl<ITabSafeQuestionTypeMapper, TabSafeQuestionTypeEntity>(), ITabSafeQuestionTypeService
