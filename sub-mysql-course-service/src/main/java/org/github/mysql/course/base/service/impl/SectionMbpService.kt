@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.SectionMbpEntity;
import org.github.mysql.course.base.mapper.ISectionMbpMapper;
import org.github.mysql.course.base.service.ISectionMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 小节 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SectionMbpService : ServiceImpl<ISectionMbpMapper, SectionMbpEntity>(), ISectionMbpService
