package org.github.ops

import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId.*
import java.util.Date

val LocalDateTime.value: String get() = "${toLocalDate()} ${toLocalTime().withNano(0)}"

val LocalDateTime.instant: Instant get() = atZone(systemDefault()).toInstant()

val LocalDateTime.date: Date get() = Date.from(instant)

val LocalDateTime.long: Long get() = instant.toEpochMilli()

val LocalDateTime.seconds: Long get() = instant.epochSecond

val LocalTime.value: String get() = withNano(0).toString()

val LocalTime.minOfDay: Int get() = toSecondOfDay() / 60
