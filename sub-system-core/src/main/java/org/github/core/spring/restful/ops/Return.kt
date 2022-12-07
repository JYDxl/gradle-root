package org.github.core.spring.restful.ops

import org.github.core.spring.restful.json.JSONArrayReturn
import org.github.core.spring.restful.json.JSONReturn

fun <V> JSONArrayReturn<V>.ktData(): Collection<V> = data

fun <V: JSONReturn> V.check() = this.also {throwIfFailed()}
