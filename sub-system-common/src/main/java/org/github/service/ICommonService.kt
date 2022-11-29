package org.github.service

import cn.hutool.core.bean.BeanUtil.copyProperties
import java.util.function.Function

interface ICommonService {
  fun <T, R> transCode(list: List<T>, clazz: Class<R>, func: Function<T, R> = Function {copyProperties(it, clazz)}): List<R>
}
