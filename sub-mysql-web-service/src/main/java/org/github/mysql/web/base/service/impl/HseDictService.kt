@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.HseDictEntity;
import org.github.mysql.web.base.mapper.IHseDictMapper;
import org.github.mysql.web.base.service.IHseDictService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 组织架构表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class HseDictService : ServiceImpl<IHseDictMapper, HseDictEntity>(), IHseDictService
