package com.avocadochif.weekly.horizontal.calendar.library.extensions

import android.view.View
import com.avocadochif.weekly.horizontal.calendar.library.listeners.SingleClickListener

internal var View.backgroundResource: Int
    get() = throw Exception("Property does not have a getter")
    set(v) = setBackgroundResource(v)

internal fun View.onSingleClickListener(onClick: (View) -> Unit) {
    setOnClickListener(SingleClickListener { onClick(it) })
}
