package org.github.ops

import cn.hutool.core.date.DateUtil.date
import cn.hutool.core.date.DateUtil.toLocalDateTime
import cn.hutool.core.date.LocalDateTimeUtil.beginOfDay
import cn.hutool.core.date.LocalDateTimeUtil.endOfDay
import java.time.LocalDateTime
import java.time.temporal.TemporalAccessor
import java.util.*

fun TemporalAccessor.toDate(): Date = date(this).toJdkDate()

fun Date.toLocalDateTime(): LocalDateTime = toLocalDateTime(this)

fun LocalDateTime.beginOfDay(): LocalDateTime = beginOfDay(this)

fun LocalDateTime.endOfDay(): LocalDateTime = endOfDay(this)
