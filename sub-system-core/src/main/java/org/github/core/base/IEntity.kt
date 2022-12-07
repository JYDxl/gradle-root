package org.github.core.base

interface IEntity: IJson {
  abstract fun pkVal(): java.io.Serializable?
}
