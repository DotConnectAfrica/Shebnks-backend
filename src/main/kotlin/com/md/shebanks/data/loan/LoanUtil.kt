package com.md.shebanks.data.loan

import java.sql.Timestamp
import java.util.*
import java.util.stream.Collectors


fun Timestamp.checkDue(months: Int): Boolean {
    val toDay = Timestamp(Date().time).toLocalDateTime().toLocalDate()
    val fromDay = this.toLocalDateTime().toLocalDate()
    return fromDay.datesUntil(toDay)
        .filter { it.dayOfMonth == 1 }
        .collect(Collectors.toList()).size <= months
}

fun Double.simpleInterest(i: Double, t: Int): Double {
    val p = this
    val si = (i.times(p).times(t)).div(100)
    return p.plus(si)
}

fun Double.monthlyPaid(i: Double, t: Int): Double {
    val p = this
    val mp = (i.div(12))
    return mp.times(p)
}