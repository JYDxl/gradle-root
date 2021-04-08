package org.github.base

import org.github.ops.spring.json

abstract class Model<T: Model<T>>: com.baomidou.mybatisplus.extension.activerecord.Model<T>() {
  fun json() = json(null)
}
