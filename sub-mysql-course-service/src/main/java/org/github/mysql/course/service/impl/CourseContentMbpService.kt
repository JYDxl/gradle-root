@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.service.impl;

import org.github.mysql.course.entity.CourseContentMbpPo;
import org.github.mysql.course.mapper.ICourseContentMbpMapper;
import org.github.mysql.course.service.ICourseContentMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 课程内容 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CourseContentMbpService : ServiceImpl<ICourseContentMbpMapper, CourseContentMbpPo>(), ICourseContentMbpService
