package com.avocadochif.weekly.horizontal.calendar.library.entity

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import com.avocadochif.weekly.horizontal.calendar.library.utils.DateUtils
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class Day(
    var timestamp: Long,
    var isSelected: Boolean,
    var style: DayViewStyle? = null
) : Parcelable {

    fun copy(): Day {
        return Day(
            timestamp = timestamp,
            isSelected = isSelected,
            style = style
        )
    }

    fun getDayTitle(): String {
        return DateUtils.getDayTitleFromTimestamp(timestamp).replaceFirstChar { it.uppercase() }
    }

    fun getDayValue(): String {
        return DateUtils.getDayNumberFromTimestamp(timestamp).toString()
    }

    @DrawableRes
    fun getDayBackgroundResId(): Int? {
        return when (isSelected) {
            true -> style?.selectedBackgroundResId
            false -> style?.unselectedBackgroundResId
        }
    }

    @DrawableRes
    fun getTitleTextColorResId(): Int? {
        return when (isSelected) {
            true -> style?.selectedTitleColorResId
            false -> style?.unselectedTitleColorResId
        }
    }

    @DrawableRes
    fun getValueTextColorResId(): Int? {
        return when (isSelected) {
            true -> style?.selectedValueColorResId
            false -> style?.unselectedValueColorResId
        }
    }

    @FontRes
    fun getTitleTextFontResId(): Int? {
        return style?.titleFontResId
    }

    @FontRes
    fun getValueTextFontResId(): Int? {
        return style?.valueFontResId
    }

}