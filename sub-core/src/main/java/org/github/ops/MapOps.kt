package org.github.ops

import org.springframework.cglib.beans.BeanMap

fun <T: Any> Map<String, Any?>.bean(clazz: Class<T>) = clazz.getDeclaredConstructor().newInstance()!!.also { BeanMap.create(it).putAll(this) }
