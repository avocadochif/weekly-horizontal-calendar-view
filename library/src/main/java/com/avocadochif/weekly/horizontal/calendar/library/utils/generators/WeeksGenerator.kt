package com.avocadochif.weekly.horizontal.calendar.library.utils.generators

import com.avocadochif.weekly.horizontal.calendar.library.entity.Day
import com.avocadochif.weekly.horizontal.calendar.library.entity.Week
import com.avocadochif.weekly.horizontal.calendar.library.utils.DateUtils
import android.text.format.DateUtils as AndroidDateUtils

internal object WeeksGenerator {

    fun generateWeeksBasedOnCountOfAvailableWeeksInPastAndFuture(before: Int, after: Int): List<Week> {
        val current = DateUtils.getTimestampOfStartCurrentDay()
        var timestamp = DateUtils.getTimestampOfStartFirstDayInWeekBefore(before)

        return mutableListOf<Week>().apply {
            for (i in 0..(before + after)) {
                this.add(Week().apply {
                    for (j in 0 until Week.COUNT_OF_DAYS_IN_WEEK) {
                        this.days.add(Day(timestamp, timestamp == current, ))
                        timestamp += AndroidDateUtils.DAY_IN_MILLIS
                    }
                })
            }
        }
    }

}