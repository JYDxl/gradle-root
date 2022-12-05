@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.CourseContentFileMbpEntity;
import org.github.mysql.course.base.mapper.ICourseContentFileMbpMapper;
import org.github.mysql.course.base.service.ICourseContentFileMbpService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 课程内容文件 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CourseContentFileMbpService : ServiceImpl<ICourseContentFileMbpMapper, CourseContentFileMbpEntity>(), ICourseContentFileMbpService
