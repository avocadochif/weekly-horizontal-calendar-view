package com.avocadochif.weekly.horizontal.calendar.library.extensions

import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

internal var TextView.textColorResource: Int
    get() = throw Exception("Property does not have a getter")
    set(v) = setTextColor(ContextCompat.getColor(this.context, v))

internal var TextView.fontFamilyResource: Int
    get() = throw Exception("Property does not have a getter")
    set(v) = setTypeface(ResourcesCompat.getFont(this.context, v))
