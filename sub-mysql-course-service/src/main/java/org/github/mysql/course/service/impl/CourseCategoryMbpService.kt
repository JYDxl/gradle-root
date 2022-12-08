@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.service.impl;

import org.github.mysql.course.entity.CourseCategoryMbpPo;
import org.github.mysql.course.mapper.ICourseCategoryMbpMapper;
import org.github.mysql.course.service.ICourseCategoryMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 课程分类 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CourseCategoryMbpService : ServiceImpl<ICourseCategoryMbpMapper, CourseCategoryMbpPo>(), ICourseCategoryMbpService
