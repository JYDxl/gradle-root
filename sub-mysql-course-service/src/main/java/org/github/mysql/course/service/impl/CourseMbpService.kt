@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.service.impl;

import org.github.mysql.course.entity.CourseMbpPo;
import org.github.mysql.course.mapper.ICourseMbpMapper;
import org.github.mysql.course.service.ICourseMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 课程 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CourseMbpService : ServiceImpl<ICourseMbpMapper, CourseMbpPo>(), ICourseMbpService
