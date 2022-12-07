package org.github.core.base

interface IEnum<C: Any, V: Any> {
  val code: C
  val value: V
}
