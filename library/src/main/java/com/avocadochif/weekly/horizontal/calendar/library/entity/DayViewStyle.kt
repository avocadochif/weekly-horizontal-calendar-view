package com.avocadochif.weekly.horizontal.calendar.library.entity

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes

internal data class DayViewStyle(
    @DrawableRes val selectedBackgroundResId: Int,
    @DrawableRes val unselectedBackgroundResId: Int,

    @ColorRes val selectedTitleColorResId: Int,
    @ColorRes val unselectedTitleColorResId: Int,

    @ColorRes val selectedValueColorResId: Int,
    @ColorRes val unselectedValueColorResId: Int,

    @FontRes val titleFontResId: Int,
    @FontRes val valueFontResId: Int
)