package com.avocadochif.weekly.horizontal.calendar.library.view.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.avocadochif.weekly.horizontal.calendar.library.databinding.ViewDayBinding
import com.avocadochif.weekly.horizontal.calendar.library.entity.Day
import com.avocadochif.weekly.horizontal.calendar.library.extensions.backgroundResource
import com.avocadochif.weekly.horizontal.calendar.library.extensions.fontFamilyResource
import com.avocadochif.weekly.horizontal.calendar.library.extensions.textColorResource

internal class DayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding = ViewDayBinding.inflate(LayoutInflater.from(context), this, true)

    fun setDay(day: Day) {
        with(binding) {
            day.getDayBackgroundResId()?.let { root.backgroundResource = it }
            day.getTitleTextColorResId()?.let { titleTV.textColorResource = it }
            day.getValueTextColorResId()?.let { valueTV.textColorResource = it }
            day.getTitleTextFontResId()?.let { titleTV.fontFamilyResource = it }
            day.getValueTextFontResId()?.let { valueTV.fontFamilyResource = it }

            titleTV.text = day.getDayTitle()
            valueTV.text = day.getDayValue()
        }
    }

}