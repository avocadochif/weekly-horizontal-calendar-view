package com.avocadochif.weekly.horizontal.calendar.library.view.recyclerview.callback

import androidx.recyclerview.widget.DiffUtil
import com.avocadochif.weekly.horizontal.calendar.library.entity.Week

internal class WeekCallback : DiffUtil.ItemCallback<Week>() {

    override fun areItemsTheSame(oldItem: Week, newItem: Week): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Week, newItem: Week): Boolean {
        return oldItem == newItem
    }

}