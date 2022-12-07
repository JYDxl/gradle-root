@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.TeacherMbpEntity;
import org.github.mysql.course.base.mapper.ITeacherMbpMapper;
import org.github.mysql.course.base.service.ITeacherMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 讲师 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class TeacherMbpService : ServiceImpl<ITeacherMbpMapper, TeacherMbpEntity>(), ITeacherMbpService
