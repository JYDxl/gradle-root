package org.github.mybatis

import com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateChainWrapper
import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.IService.DEFAULT_BATCH_SIZE
import com.google.common.collect.Lists.partition
import org.github.base.IMapper

fun <T> IService<T>.insertBatch(entityList: List<T>): Int {
    val mapper = baseMapper as IMapper<T>
    val partition: List<List<T>> = partition(entityList, DEFAULT_BATCH_SIZE)
    return partition.sumOf { mapper.insertBatchSomeColumn(it) }
}

fun <T : Any> IService<T>.ktQueryWrapper(): KtQueryChainWrapper<T> = ktQuery()

fun <T : Any> IService<T>.ktUpdateWrapper(): KtUpdateChainWrapper<T> = ktUpdate()
