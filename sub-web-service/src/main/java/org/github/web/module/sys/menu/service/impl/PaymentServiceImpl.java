package org.github.web.module.sys.menu.service.impl;

import lombok.*;
import org.github.exception.ParamsErrorException;
import org.github.mysql.web.base.entity.PaymentMbpEntity;
import org.github.mysql.web.base.service.IPaymentMbpService;
import org.github.web.module.sys.menu.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.lang.String.*;

@Service
public class PaymentServiceImpl implements IPaymentService {
  @Autowired
  private IPaymentMbpService paymentMbpService;

  @Override
  public boolean create(@NonNull PaymentMbpEntity bo) {
    return paymentMbpService.save(bo);
  }

  @Override
  public @NonNull PaymentMbpEntity get(long id) {
    val entity = paymentMbpService.getById(id);
    if (entity == null) throw new ParamsErrorException(format("[id: %s]对应的记录不存在", id));
    return entity;
  }
}
