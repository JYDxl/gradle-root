package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.TabSafeQuestionTypeEntity;
import org.github.mysql.web.base.mapper.ITabSafeQuestionTypeMapper;
import org.github.mysql.web.base.service.ITabSafeQuestionTypeService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 安全问题类别 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-21
 */
@Service
public class TabSafeQuestionTypeServiceImpl extends ServiceImpl<ITabSafeQuestionTypeMapper, TabSafeQuestionTypeEntity> implements ITabSafeQuestionTypeService {}
