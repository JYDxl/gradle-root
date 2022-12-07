@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.MemberMbpEntity;
import org.github.mysql.course.base.mapper.IMemberMbpMapper;
import org.github.mysql.course.base.service.IMemberMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 会员 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MemberMbpService : ServiceImpl<IMemberMbpMapper, MemberMbpEntity>(), IMemberMbpService
