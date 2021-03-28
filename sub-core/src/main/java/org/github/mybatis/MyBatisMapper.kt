package org.github.mybatis

import org.springframework.stereotype.Component
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.CLASS

@Target(CLASS)
@Retention(RUNTIME)
@MustBeDocumented
@Component
annotation class MyBatisMapper
