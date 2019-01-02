package org.github.spring.annotation

import kotlin.annotation.AnnotationRetention.SOURCE

@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CONSTRUCTOR)
@Retention(SOURCE)
@MustBeDocumented
annotation class Pray
