@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.CourseContentFileEntity;
import org.github.mysql.course.base.mapper.ICourseContentFileMapper;
import org.github.mysql.course.base.service.ICourseContentFileService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 课程内容文件 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CourseContentFileService : ServiceImpl<ICourseContentFileMapper, CourseContentFileEntity>(), ICourseContentFileService
