package org.github.base

interface IEntity: IJson {
  abstract fun pkVal(): java.io.Serializable?
}
