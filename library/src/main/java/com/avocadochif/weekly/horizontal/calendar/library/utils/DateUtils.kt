package com.avocadochif.weekly.horizontal.calendar.library.utils

import java.text.SimpleDateFormat
import java.util.*
import android.text.format.DateUtils as AndroidDateUtils

internal object DateUtils {

    /**
     * @sample 'Tue'
     **/
    private val shortFormatOfDay: SimpleDateFormat by lazy(LazyThreadSafetyMode.NONE) {
        SimpleDateFormat("E", Locale.getDefault())
    }

    fun getDayTitleFromTimestamp(timestamp: Long): String {
        return shortFormatOfDay.format(Date(timestamp))
    }

    fun getDayNumberFromTimestamp(timestamp: Long): Int {
        return Calendar.getInstance().apply {
            timeInMillis = timestamp
        }.get(Calendar.DAY_OF_MONTH)
    }

    fun getTimestampOfStartCurrentDay(): Long {
        return Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            clear(Calendar.MINUTE)
            clear(Calendar.SECOND)
            clear(Calendar.MILLISECOND)
        }.timeInMillis
    }

    fun getTimestampOfStartFirstDayInThisWeek(): Long {
        return Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            clear(Calendar.MINUTE)
            clear(Calendar.SECOND)
            clear(Calendar.MILLISECOND)
        }.apply {
            set(Calendar.DAY_OF_WEEK, firstDayOfWeek)
        }.timeInMillis
    }

    fun getTimestampOfStartFirstDayInWeekBefore(before: Int): Long {
        return getTimestampOfStartFirstDayInThisWeek() - before * AndroidDateUtils.WEEK_IN_MILLIS
    }

}