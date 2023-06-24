package com.example.core.extension

import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.minus
import kotlinx.datetime.plus

val LocalDate.startOfWeek: LocalDate get() {
    if (dayOfWeek.value == 0) return this
    return this.minus(dayOfWeek.value, DateTimeUnit.DAY)
}

val LocalDate.endOfWeek: LocalDate get() {
    if (dayOfWeek.value == 6) return this
    return this.plus(6 - dayOfWeek.value, DateTimeUnit.DAY)
}

val LocalDate.daysInWeek: List<LocalDate> get() {
    val startOfWeek = startOfWeek
    val days = mutableListOf<LocalDate>()

    for (i in 0 until 7) {
        days.add(startOfWeek.plus(i, DateTimeUnit.DAY))
    }

    return days
}
