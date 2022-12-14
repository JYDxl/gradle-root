package org.github.core.base

abstract class Model<T : Model<T>> : com.baomidou.mybatisplus.extension.activerecord.Model<T>(), IEntity
