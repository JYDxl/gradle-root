@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.CourseContentMbpEntity;
import org.github.mysql.course.base.mapper.ICourseContentMbpMapper;
import org.github.mysql.course.base.service.ICourseContentMbpService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 课程内容 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CourseContentMbpService : ServiceImpl<ICourseContentMbpMapper, CourseContentMbpEntity>(), ICourseContentMbpService
