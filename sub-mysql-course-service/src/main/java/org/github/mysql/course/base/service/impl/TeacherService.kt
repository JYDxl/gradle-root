@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.TeacherEntity;
import org.github.mysql.course.base.mapper.ITeacherMapper;
import org.github.mysql.course.base.service.ITeacherService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 讲师 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class TeacherService : ServiceImpl<ITeacherMapper, TeacherEntity>(), ITeacherService
