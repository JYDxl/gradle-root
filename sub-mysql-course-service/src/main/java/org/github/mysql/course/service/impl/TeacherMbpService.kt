@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.service.impl;

import org.github.mysql.course.entity.TeacherMbpPo;
import org.github.mysql.course.mapper.ITeacherMbpMapper;
import org.github.mysql.course.service.ITeacherMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 讲师 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class TeacherMbpService : ServiceImpl<ITeacherMbpMapper, TeacherMbpPo>(), ITeacherMbpService
