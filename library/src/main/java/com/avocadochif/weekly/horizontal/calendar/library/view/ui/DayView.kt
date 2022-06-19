package com.avocadochif.weekly.horizontal.calendar.library.view.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.avocadochif.weekly.horizontal.calendar.library.databinding.ViewDayBinding

internal class DayView @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding = ViewDayBinding.inflate(LayoutInflater.from(context), this, true)

    init {

    }

}