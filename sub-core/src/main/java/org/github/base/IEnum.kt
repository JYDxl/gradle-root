package org.github.base

interface IEnum<C: Any, V: Any> {
  val code: C
  val value: V
}
