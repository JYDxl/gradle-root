package org.github.common.service

import cn.hutool.core.bean.BeanUtil.copyProperties
import java.util.function.Function

interface ICommonService {
  fun <T:Any, R:Any> trans(list: List<T>, clazz: Class<R>, func: Function<T, R> = Function {copyProperties(it, clazz)}): List<R>

  fun <T:Any, R:Any> trans(obj: T, clazz: Class<R>, func: Function<T, R> = Function {copyProperties(it, clazz)}): R
}
