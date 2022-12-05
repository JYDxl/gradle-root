@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.MemberCourseMbpEntity;
import org.github.mysql.course.base.mapper.IMemberCourseMbpMapper;
import org.github.mysql.course.base.service.IMemberCourseMbpService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 会员课程报名 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MemberCourseMbpService : ServiceImpl<IMemberCourseMbpMapper, MemberCourseMbpEntity>(), IMemberCourseMbpService
