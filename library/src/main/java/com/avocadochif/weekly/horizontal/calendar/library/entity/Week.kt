package com.avocadochif.weekly.horizontal.calendar.library.entity

internal class Week {

    override fun equals(other: Any?): Boolean {
        return this === (other as Week)
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

}