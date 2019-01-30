package org.github.util

import org.springframework.beans.BeanUtils.copyProperties

/** copy data.  */
fun <T> copy(target: Class<out T>, source: T) = target.newInstance()!!.apply { copyProperties(source!!, this!!) }

/** copy data.  */
fun <T> copy(target: Class<out T>, vararg source: T) = source.asSequence().map { copy(target, it) }.toList()

/** copy data.  */
fun <T> copy(target: Class<out T>, source: Collection<T>) = source.asSequence().map { copy(target, it) }.toList()
