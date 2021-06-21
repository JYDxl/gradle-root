package org.github.spring.restful.ops

import org.github.spring.restful.json.JSONArrayReturn

fun <V> JSONArrayReturn<V>.ktData(): Collection<V> = data
