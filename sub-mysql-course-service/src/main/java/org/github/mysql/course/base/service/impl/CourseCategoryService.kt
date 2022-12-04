@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.CourseCategoryEntity;
import org.github.mysql.course.base.mapper.ICourseCategoryMapper;
import org.github.mysql.course.base.service.ICourseCategoryService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 课程分类 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CourseCategoryService : ServiceImpl<ICourseCategoryMapper, CourseCategoryEntity>(), ICourseCategoryService
