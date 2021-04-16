package org.github.base

abstract class Model<T: Model<T>>: com.baomidou.mybatisplus.extension.activerecord.Model<T>(), IJson {}
