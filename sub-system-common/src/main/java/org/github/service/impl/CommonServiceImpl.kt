package org.github.service.impl

import cn.hutool.core.bean.BeanUtil.edit
import cn.hutool.core.util.ReflectUtil.getFieldValue
import cn.hutool.core.util.ReflectUtil.setFieldValue
import org.github.base.CodeType
import org.github.cache.EnumCache
import org.github.service.ICommonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.reflect.Field


@Component
class CommonServiceImpl: ICommonService {
  @Autowired
  private lateinit var enumCache: EnumCache

  override fun <T> transCode(list: List<T>): List<T> = list.onEach {
    edit(it) {field: Field ->
      setCodeDesc(it, field)
      return@edit field
    }
  }

  private fun <T> setCodeDesc(obj: T, field: Field) {
    val codeType: CodeType = field.getAnnotation(CodeType::class.java) ?: return
    val code = getFieldValue(obj, codeType.field) ?: return
    enumCache.get<Any, String>(codeType.type, code)?.let {setFieldValue(obj, field, it)}
  }
}
