@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.service.impl;

import org.github.mysql.course.entity.SectionMbpPo;
import org.github.mysql.course.mapper.ISectionMbpMapper;
import org.github.mysql.course.service.ISectionMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 小节 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SectionMbpService : ServiceImpl<ISectionMbpMapper, SectionMbpPo>(), ISectionMbpService
