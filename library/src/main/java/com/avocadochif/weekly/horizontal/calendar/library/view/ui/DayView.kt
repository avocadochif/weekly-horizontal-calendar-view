package com.avocadochif.weekly.horizontal.calendar.library.view.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.avocadochif.weekly.horizontal.calendar.library.databinding.ViewDayBinding

internal class DayView @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = ViewDayBinding.inflate(LayoutInflater.from(context), this, true)

}