@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.TabSafeQuestionDataEntity;
import org.github.mysql.web.base.mapper.ITabSafeQuestionDataMapper;
import org.github.mysql.web.base.service.ITabSafeQuestionDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 安全问题库 服务实现类
 *
 * @author JYD_XL
 * @since 2021-05-30
 */
@Service
open class TabSafeQuestionDataServiceImpl : ServiceImpl<ITabSafeQuestionDataMapper, TabSafeQuestionDataEntity>(), ITabSafeQuestionDataService
