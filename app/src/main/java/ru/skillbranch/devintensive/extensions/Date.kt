package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String="HH:mm:ss  dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date:Date = Date()): String {
//    TODO(reason = "not implemented")

    val resultStr: String
    val currentDate = Date()
    val diff: Long = (date.time - currentDate.time) / 1000L

    if (diff < 0){
        when(Math.abs(diff)){
            in 0..1 -> resultStr = "только что"
            in 1..45 -> resultStr = "несколько секунд назад"
            in 45..75 -> resultStr = "минуту назад"
            in 75..2700 -> resultStr = "${Math.abs(diff) / 60} минут назад"
            in 2700..4500 -> resultStr = "час назад"
            in 4500..79200 -> resultStr = "${Math.abs(diff) / 60 / 60} часов назад"
            in 79200..93600 -> resultStr = "день назад"
            in 93600..31104000 -> resultStr = "${Math.abs(diff) / 60 / 60 / 24} дней назад"
            in 31104000..Long.MAX_VALUE -> resultStr = "более года назад"
            else -> resultStr = ""

        }
    }else{
        when(Math.abs(diff)){
            in 0..1 -> resultStr = "только что"
            in 1..45 -> resultStr = "через несколько секунд"
            in 45..75 -> resultStr = "через минуту"
            in 75..2700 -> resultStr = "через ${Math.abs(diff) / 60} минут"
            in 2700..4500 -> resultStr = "через час"
            in 4500..79200 -> resultStr = "через ${Math.abs(diff) / 60 / 60} часов"
            in 79200..93600 -> resultStr = "через день"
            in 93600..31104000 -> resultStr = "через ${Math.abs(diff) / 60 / 60 / 24} дней"
            in 31104000..Long.MAX_VALUE -> resultStr = "более чем через год"
            else -> resultStr = ""


        }
    }

    return resultStr
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}