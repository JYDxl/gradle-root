package org.github.ops

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.function.Supplier
import kotlin.reflect.KClass

//TODO JYD_XL format
//TODO 测试
fun Logger.debug(supplier: Supplier<String?>, ex: Throwable? = null) = if(this.isDebugEnabled) this.debug(supplier.get().toString(), ex) else Unit

fun Logger.trace(supplier: Supplier<String?>, ex: Throwable? = null) = if(this.isTraceEnabled) this.trace(supplier.get().toString(), ex) else Unit

//fun log(clazz: KClass<*>) = LoggerFactory.getLogger(clazz::class.java)!!

val KClass<*>.log get() = LoggerFactory.getLogger(this::class.java)!!
