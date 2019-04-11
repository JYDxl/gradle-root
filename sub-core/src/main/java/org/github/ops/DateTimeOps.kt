package org.github.ops

import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.util.Date

val LocalDateTime.value get() = "${toLocalDate()} ${toLocalTime().withNano(0)}"

val LocalDateTime.instant get() = atZone(ZoneId.systemDefault()).toInstant()!!

val LocalDateTime.date get() = Date.from(instant)!!

val LocalDateTime.long get() = instant.toEpochMilli()

val LocalDateTime.seconds get() = instant.epochSecond

val LocalTime.value get() = withNano(0).toString()

val LocalTime.minOfDay get() = toSecondOfDay() / 60
