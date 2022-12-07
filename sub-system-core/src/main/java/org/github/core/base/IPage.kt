package org.github.core.base

import com.baomidou.mybatisplus.core.metadata.IPage

interface IPage<T>: IJson, IPage<T> {
  override fun getRecords(): List<T>

  override fun getTotal(): Long
}
