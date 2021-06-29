package org.github.base

import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.IService.DEFAULT_BATCH_SIZE
import com.google.common.collect.Lists.partition
import org.springframework.transaction.annotation.Transactional

interface IService<T>: IService<T> {
  @Transactional(rollbackFor = [Exception::class])
  fun insertBatch(entityList: List<T>): Int {
    val mapper = baseMapper as IMapper<T>
    val partition: List<List<T>> = partition(entityList, DEFAULT_BATCH_SIZE)
    return partition.sumOf {mapper.insertBatchSomeColumn(it)}
  }
}
