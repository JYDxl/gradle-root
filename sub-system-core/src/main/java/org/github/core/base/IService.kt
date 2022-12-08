package org.github.core.base

import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.IService.DEFAULT_BATCH_SIZE
import com.google.common.collect.Lists.partition

interface IService<T>: IService<T> {
  fun insertBatch(entityList: List<T>): Int {
    val mapper = baseMapper as IMapper<T>
    val partition: List<List<T>> = partition(entityList, DEFAULT_BATCH_SIZE)
    return partition.sumOf {mapper.insertBatchSomeColumn(it)}
  }
}
