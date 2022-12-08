@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.service.impl;

import org.github.mysql.course.entity.MemberCourseMbpPo;
import org.github.mysql.course.mapper.IMemberCourseMbpMapper;
import org.github.mysql.course.service.IMemberCourseMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 会员课程报名 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MemberCourseMbpService : ServiceImpl<IMemberCourseMbpMapper, MemberCourseMbpPo>(), IMemberCourseMbpService
