package org.github.spring.restful.ops

import org.github.spring.restful.json.JSONArrayReturn
import org.github.spring.restful.json.JSONReturn

fun <V> JSONArrayReturn<V>.ktData(): Collection<V> = data

fun <V: JSONReturn> V.check() = this.also {throwIfFailed()}
