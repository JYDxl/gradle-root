package org.github.mybatis.ops

import cn.hutool.core.bean.BeanUtil.copyProperties
import cn.hutool.core.bean.copier.CopyOptions.create
import com.baomidou.mybatisplus.extension.conditions.query.ChainQuery
import com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateChainWrapper
import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.IService.DEFAULT_BATCH_SIZE
import com.google.common.collect.Lists.partition
import org.github.base.IEntity
import org.github.base.IMapper
import org.github.base.IPage

fun <T: IEntity> IService<T>.insertBatch(entityList: List<T>): Int {
  val mapper = baseMapper as IMapper<T>
  val partition: List<List<T>> = partition(entityList, DEFAULT_BATCH_SIZE)
  return partition.sumOf {mapper.insertBatchSomeColumn(it)}
}

fun <T: IEntity> IService<T>.ktQueryWrapper(): KtQueryChainWrapper<T> = ktQuery()

fun <T: IEntity> IService<T>.ktUpdateWrapper(): KtUpdateChainWrapper<T> = ktUpdate()

fun <T: IEntity> IService<T>.ktGetById(id: java.io.Serializable): T? = getById(id)

fun <T: IEntity> IService<T>.ktListByIds(ids: List<java.io.Serializable>): MutableList<T> = if (ids.isEmpty()) arrayListOf() else listByIds(ids)

fun <T: IEntity> IService<T>.ktUpdateByIdSelective(entity: IEntity): Boolean {
  val record = ktGetById(requireNotNull(entity.pkVal()))
  copyProperties(entity, requireNotNull(record), create().ignoreNullValue())
  return updateById(record)
}

fun <T: IEntity> ChainQuery<T>.ktPage(page: IPage<T>): IPage<T> = page(page)

fun <T: IEntity> ChainQuery<T>.ktList(): MutableList<T> = list()

fun <T: IEntity> ChainQuery<T>.ktInList(`in`: List<Any>): MutableList<T> = if (`in`.isEmpty()) arrayListOf() else list()

fun <T: IEntity> ChainQuery<T>.ktInPage(`in`: List<Any>, page: IPage<T>): IPage<T> = if (`in`.isEmpty()) page else ktPage(page)
