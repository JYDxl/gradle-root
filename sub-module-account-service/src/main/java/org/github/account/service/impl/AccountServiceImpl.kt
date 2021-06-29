package org.github.account.service.impl

import org.github.account.dto.DecreaseAccountBO
import org.github.account.service.IAccountService
import org.github.exception.ParamsErrorException
import org.github.mybatis.ops.ktOne
import org.github.mybatis.ops.ktQueryWrapper
import org.github.mysql.seata.account.base.entity.TAccountEntity
import org.github.mysql.seata.account.base.service.ITAccountService
import org.github.spring.restful.json.JSONDataReturn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl : IAccountService {
  @Autowired
  private lateinit var accountMbpService: ITAccountService

  override fun decreaseMoney(bo: DecreaseAccountBO): JSONDataReturn<Boolean> {
    val query = accountMbpService.ktQueryWrapper()
    query.eq(TAccountEntity::userId, bo.userId)
    val accountEntity = query.ktOne() ?: throw ParamsErrorException("账户【userId：${bo.userId}】不存在")
    if (accountEntity.residue!! < bo.money) throw ParamsErrorException("账户【userId：${accountEntity.userId}】余额不足【${accountEntity.residue} < ${bo.money}】")

    accountEntity.used = accountEntity.used!! + bo.money
    accountEntity.residue = accountEntity.residue!! - bo.money
    val result = accountMbpService.updateById(accountEntity)

    return JSONDataReturn.of(result)
  }
}
