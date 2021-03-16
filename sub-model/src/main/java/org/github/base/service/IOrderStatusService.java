package org.github.base.service;

import org.github.base.entity.OrderStatusEntity;
import org.github.base.IService;

/**
 * <p>
 * 订单状态表;订单的每个状态更改都需要进行记录
10：待付款  20：已付款，待发货  30：已发货，待收货（7天自动确认）  40：交易成功（此时可以评价）50：交易关闭（待付款时，用户取消 或 长时间未付款，系统识别后自动关闭）
退货/退货，此分支流程不做，所以不加入 服务类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-16
 */
public interface IOrderStatusService extends IService<OrderStatusEntity> {}
