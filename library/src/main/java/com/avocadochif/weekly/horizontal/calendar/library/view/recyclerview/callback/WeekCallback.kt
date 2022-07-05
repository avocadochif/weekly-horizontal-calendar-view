package com.avocadochif.weekly.horizontal.calendar.library.view.recyclerview.callback

import androidx.core.os.bundleOf
import androidx.recyclerview.widget.DiffUtil
import com.avocadochif.weekly.horizontal.calendar.library.entity.Week

internal class WeekCallback : DiffUtil.ItemCallback<Week>() {

    override fun areItemsTheSame(oldItem: Week, newItem: Week): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Week, newItem: Week): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: Week, newItem: Week): Any? {
        oldItem.days.zip(newItem.days).forEach { (oldDay, newDay) ->
            return when (oldDay.isSelected == newDay.isSelected) {
                true -> super.getChangePayload(oldItem, newItem)
                false -> bundleOf(KEY_WEEK to newItem)
            }
        }
        return super.getChangePayload(oldItem, newItem)
    }

    companion object {
        internal const val KEY_WEEK = "key.week"
    }

}