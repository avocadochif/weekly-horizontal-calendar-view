package com.avocadochif.weekly.horizontal.calendar.library.extensions

internal fun Int?.orZero(): Int {
    return this ?: 0
}