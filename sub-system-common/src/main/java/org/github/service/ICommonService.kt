package org.github.service

interface ICommonService {
  fun <T> transCode(list: List<T>): List<T>
}
