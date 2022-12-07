@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.CourseMbpEntity;
import org.github.mysql.course.base.mapper.ICourseMbpMapper;
import org.github.mysql.course.base.service.ICourseMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 课程 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CourseMbpService : ServiceImpl<ICourseMbpMapper, CourseMbpEntity>(), ICourseMbpService
