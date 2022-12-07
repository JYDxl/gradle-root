package org.github.core.base

import com.baomidou.mybatisplus.core.mapper.BaseMapper

interface IMapper<T>: BaseMapper<T> {
  fun insertBatchSomeColumn(entityList: List<T>): Int
}
