@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service;

import org.github.mysql.leadnews.base.entity.ApBehaviorEntryEntity;
import org.github.base.IService;

/**
 * APP行为实体表,一个行为实体可能是用户或者设备，或者其它 服务类
 *
 * @author JYD_XL
 */
interface IApBehaviorEntryService : IService<ApBehaviorEntryEntity>
