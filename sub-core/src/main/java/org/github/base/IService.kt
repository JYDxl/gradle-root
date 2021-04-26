package org.github.base

import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.IService.DEFAULT_BATCH_SIZE
import com.google.common.collect.Lists.partition
import org.springframework.transaction.annotation.Transactional

interface IService<T> : IService<T> {
    @Transactional(rollbackFor = [Exception::class])
    fun insertBatch(entityList: List<T>, batchSize: Int = DEFAULT_BATCH_SIZE): Int {
        val mapper = baseMapper as IMapper<T>
        val partition: List<List<T>> = partition(entityList, batchSize)
        return partition.map { mapper.insertBatchSomeColumn(it) }.sum()
    }
}
