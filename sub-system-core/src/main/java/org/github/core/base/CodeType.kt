package org.github.core.base

import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.FIELD

@Target(FIELD)
@Retention(RUNTIME)
annotation class CodeType(val type: String, val field: String, val underLine: Boolean = true)
