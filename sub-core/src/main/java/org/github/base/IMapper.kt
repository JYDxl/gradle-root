package org.github.base

import com.baomidou.mybatisplus.core.mapper.BaseMapper

interface IMapper<T>: BaseMapper<T> {
  fun insertBatchSomeColumn(entityList: Collection<T>): Int
}
