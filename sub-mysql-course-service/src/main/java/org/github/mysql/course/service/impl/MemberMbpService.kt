@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.service.impl;

import org.github.mysql.course.entity.MemberMbpPo;
import org.github.mysql.course.mapper.IMemberMbpMapper;
import org.github.mysql.course.service.IMemberMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 会员 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MemberMbpService : ServiceImpl<IMemberMbpMapper, MemberMbpPo>(), IMemberMbpService
