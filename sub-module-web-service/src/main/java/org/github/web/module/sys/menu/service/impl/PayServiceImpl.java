package org.github.web.module.sys.menu.service.impl;

import lombok.*;
import org.github.exception.ClientException;
import org.github.mysql.mydb.base.entity.PaymentEntity;
import org.github.mysql.mydb.base.service.IPaymentService;
import org.github.web.module.sys.menu.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.lang.String.*;

@Service
public class PayServiceImpl implements IPayService {
  @Autowired
  private IPaymentService paymentService;

  @Override
  public boolean create(@NonNull PaymentEntity bo) {
    return paymentService.save(bo);
  }

  @Override
  public @NonNull PaymentEntity get(long id) {
    val entity = paymentService.getById(id);
    if (entity == null) throw new ClientException(format("[id: %s]对应的记录不存在", id));
    return entity;
  }
}
