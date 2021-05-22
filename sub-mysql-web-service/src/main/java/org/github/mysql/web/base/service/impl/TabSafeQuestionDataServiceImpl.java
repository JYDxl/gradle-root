package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.TabSafeQuestionDataEntity;
import org.github.mysql.web.base.mapper.ITabSafeQuestionDataMapper;
import org.github.mysql.web.base.service.ITabSafeQuestionDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 安全问题库 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-22
 */
@Service
public class TabSafeQuestionDataServiceImpl extends ServiceImpl<ITabSafeQuestionDataMapper, TabSafeQuestionDataEntity> implements ITabSafeQuestionDataService {}
