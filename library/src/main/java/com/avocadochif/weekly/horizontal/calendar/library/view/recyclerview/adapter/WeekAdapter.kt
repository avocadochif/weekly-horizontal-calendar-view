package com.avocadochif.weekly.horizontal.calendar.library.view.recyclerview.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.avocadochif.weekly.horizontal.calendar.library.databinding.ItemWeekBinding
import com.avocadochif.weekly.horizontal.calendar.library.entity.Day
import com.avocadochif.weekly.horizontal.calendar.library.entity.Week
import com.avocadochif.weekly.horizontal.calendar.library.view.recyclerview.callback.WeekCallback
import com.avocadochif.weekly.horizontal.calendar.library.view.recyclerview.viewholder.WeekViewHolder

internal class WeekAdapter(
    private val onDaySelected: (day: Day) -> Unit
) : ListAdapter<Week, WeekViewHolder>(WeekCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekViewHolder {
        return WeekViewHolder(ItemWeekBinding.inflate(LayoutInflater.from(parent.context), parent, false), onDaySelected)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: WeekViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun onBindViewHolder(holder: WeekViewHolder, position: Int, payloads: MutableList<Any>) {
        when (payloads.isEmpty()) {
            true -> holder.bind(currentList[position])
            false -> (payloads[0] as? Bundle)?.getParcelable<Week>(WeekCallback.KEY_WEEK)?.let { holder.bind(it) }
        }
    }
}