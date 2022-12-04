@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.CourseContentEntity;
import org.github.mysql.course.base.mapper.ICourseContentMapper;
import org.github.mysql.course.base.service.ICourseContentService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 课程内容 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CourseContentService : ServiceImpl<ICourseContentMapper, CourseContentEntity>(), ICourseContentService
