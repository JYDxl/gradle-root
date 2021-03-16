package org.github.mybatis

import org.springframework.stereotype.Component
import kotlin.annotation.AnnotationRetention.*
import kotlin.annotation.AnnotationTarget.*

@Target(CLASS)
@Retention(RUNTIME)
@MustBeDocumented
@Component
annotation class MyBatisMapper
