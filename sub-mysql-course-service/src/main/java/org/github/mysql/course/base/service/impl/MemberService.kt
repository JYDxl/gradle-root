@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.MemberEntity;
import org.github.mysql.course.base.mapper.IMemberMapper;
import org.github.mysql.course.base.service.IMemberService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 会员 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MemberService : ServiceImpl<IMemberMapper, MemberEntity>(), IMemberService
