@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.SectionEntity;
import org.github.mysql.course.base.mapper.ISectionMapper;
import org.github.mysql.course.base.service.ISectionService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 小节 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SectionService : ServiceImpl<ISectionMapper, SectionEntity>(), ISectionService
