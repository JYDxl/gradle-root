@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApBehaviorEntryEntity;
import org.github.mysql.leadnews.base.mapper.IApBehaviorEntryMapper;
import org.github.mysql.leadnews.base.service.IApBehaviorEntryService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP行为实体表,一个行为实体可能是用户或者设备，或者其它 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApBehaviorEntryServiceImpl : ServiceImpl<IApBehaviorEntryMapper, ApBehaviorEntryEntity>(), IApBehaviorEntryService
