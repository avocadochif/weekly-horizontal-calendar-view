package com.avocadochif.weekly.horizontal.calendar.library.extensions

internal fun <T> List<T>.indexOfFirstOrZero(predicate: (T) -> Boolean): Int {
    for ((index, item) in this.withIndex()) {
        if (predicate(item)) {
            return index
        }
    }
    return 0
}

internal fun <T> List<T>.indexOfFirstOrNull(predicate: (T) -> Boolean): Int? {
    for ((index, item) in this.withIndex()) {
        if (predicate(item)) {
            return index
        }
    }
    return null
}