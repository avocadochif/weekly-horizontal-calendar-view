package com.avocadochif.weekly.horizontal.calendar.library.view.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.avocadochif.weekly.horizontal.calendar.library.databinding.ViewWeeklyHorizontalCalendarBinding
import com.avocadochif.weekly.horizontal.calendar.library.entity.Week
import com.avocadochif.weekly.horizontal.calendar.library.view.recyclerview.adapter.WeekAdapter

class WeeklyHorizontalCalendarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = ViewWeeklyHorizontalCalendarBinding.inflate(LayoutInflater.from(context), this, true)

    private val adapter = WeekAdapter()

    init {
        binding.weeksRV.apply {
            setHasFixedSize(true)
            adapter = this@WeeklyHorizontalCalendarView.adapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        PagerSnapHelper().apply {
            attachToRecyclerView(binding.weeksRV)
        }

        adapter.submitList(mutableListOf(Week(), Week(), Week(), Week()))
    }

}