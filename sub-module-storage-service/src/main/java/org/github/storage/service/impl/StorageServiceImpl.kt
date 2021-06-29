package org.github.storage.service.impl

import org.github.exception.ParamsErrorException
import org.github.mybatis.ops.ktOne
import org.github.mybatis.ops.ktQueryWrapper
import org.github.mysql.seata.storage.base.entity.TStorageEntity
import org.github.mysql.seata.storage.base.service.ITStorageService
import org.github.spring.restful.json.JSONDataReturn
import org.github.storage.dto.DecreaseProductBO
import org.github.storage.service.IStorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StorageServiceImpl : IStorageService {
  @Autowired
  private lateinit var storageMbpService: ITStorageService

  override fun decreaseProduct(bo: DecreaseProductBO): JSONDataReturn<Boolean> {
    val query = storageMbpService.ktQueryWrapper()
    query.eq(TStorageEntity::productId, bo.productId)
    val storageEntity = query.ktOne() ?: throw ParamsErrorException("产品【id：${bo.productId}】不存在")
    if (storageEntity.residue!! < bo.count) throw ParamsErrorException("产品【id：${storageEntity.productId}】库存不足【${storageEntity.residue} < ${bo.count}】")
    storageEntity.used = storageEntity.used!! + bo.count
    storageEntity.residue = storageEntity.residue!! + bo.count
    val result = storageMbpService.updateById(storageEntity)
    return JSONDataReturn.of(result)
  }
}
