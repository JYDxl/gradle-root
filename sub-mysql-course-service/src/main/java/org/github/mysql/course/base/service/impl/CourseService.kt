@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.CourseEntity;
import org.github.mysql.course.base.mapper.ICourseMapper;
import org.github.mysql.course.base.service.ICourseService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 课程 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CourseService : ServiceImpl<ICourseMapper, CourseEntity>(), ICourseService
