package com.avocadochif.weekly.horizontal.calendar.library.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class Week(
    val id: Int,
    val days: MutableList<Day> = mutableListOf()
) : Parcelable {

    fun copy(): Week {
        return Week(
            id = id,
            days = mutableListOf<Day>().apply {
                days.forEach { add(it.copy()) }
            })
    }

    companion object {
        const val COUNT_OF_DAYS_IN_WEEK = 7
        const val INDEX_OF_MONDAY = 0
        const val INDEX_OF_TUESDAY = 1
        const val INDEX_OF_WEDNESDAY = 2
        const val INDEX_OF_THURSDAY = 3
        const val INDEX_OF_FRIDAY = 4
        const val INDEX_OF_SATURDAY = 5
        const val INDEX_OF_SUNDAY = 6
    }

}