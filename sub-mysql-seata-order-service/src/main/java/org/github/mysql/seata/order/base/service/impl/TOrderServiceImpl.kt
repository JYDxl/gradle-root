@file:Suppress("RedundantSemicolon")

package org.github.mysql.seata.order.base.service.impl;

import org.github.mysql.seata.order.base.entity.TOrderEntity;
import org.github.mysql.seata.order.base.mapper.ITOrderMapper;
import org.github.mysql.seata.order.base.service.ITOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 订单表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class TOrderServiceImpl : ServiceImpl<ITOrderMapper, TOrderEntity>(), ITOrderService
