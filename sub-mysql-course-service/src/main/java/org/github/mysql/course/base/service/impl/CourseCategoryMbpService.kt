@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.CourseCategoryMbpEntity;
import org.github.mysql.course.base.mapper.ICourseCategoryMbpMapper;
import org.github.mysql.course.base.service.ICourseCategoryMbpService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 课程分类 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CourseCategoryMbpService : ServiceImpl<ICourseCategoryMbpMapper, CourseCategoryMbpEntity>(), ICourseCategoryMbpService
