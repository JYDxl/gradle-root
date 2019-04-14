package org.github.component.mybatis

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import org.apache.ibatis.reflection.MetaObject
import org.github.ops.commonMapper
import org.springframework.stereotype.Component

@Component
class NaiveMetaObjectHandler: MetaObjectHandler {
  override fun insertFill(meta: MetaObject) {

    // setFieldValByName("createdAt", commonMapper.now(), meta)
  }

  override fun updateFill(meta: MetaObject) {
    setUpdateFieldValByName("updatedAt", commonMapper.now(), meta)
  }
}
