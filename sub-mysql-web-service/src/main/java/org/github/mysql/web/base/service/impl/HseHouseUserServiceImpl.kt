@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.HseHouseUserEntity;
import org.github.mysql.web.base.mapper.IHseHouseUserMapper;
import org.github.mysql.web.base.service.IHseHouseUserService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 房东信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class HseHouseUserServiceImpl : ServiceImpl<IHseHouseUserMapper, HseHouseUserEntity>(), IHseHouseUserService
