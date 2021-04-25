package org.github.base.service.impl;

import org.github.base.entity.TabSafeQuestionDataEntity;
import org.github.base.mapper.ITabSafeQuestionDataMapper;
import org.github.base.service.ITabSafeQuestionDataService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 安全问题库 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-25
 */
@Service
public class TabSafeQuestionDataServiceImpl extends ServiceImpl<ITabSafeQuestionDataMapper, TabSafeQuestionDataEntity> implements ITabSafeQuestionDataService {}
