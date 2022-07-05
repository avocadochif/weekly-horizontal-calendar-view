package com.avocadochif.weekly.horizontal.calendar.library.entity

internal data class Week(
    val days: MutableList<Day> = mutableListOf()
) {

    override fun equals(other: Any?): Boolean {
        return this === (other as Week)
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
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