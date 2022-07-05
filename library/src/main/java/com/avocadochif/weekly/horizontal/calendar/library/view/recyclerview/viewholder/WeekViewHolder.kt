package com.avocadochif.weekly.horizontal.calendar.library.view.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.avocadochif.weekly.horizontal.calendar.library.databinding.ItemWeekBinding
import com.avocadochif.weekly.horizontal.calendar.library.entity.Day
import com.avocadochif.weekly.horizontal.calendar.library.entity.Week
import com.avocadochif.weekly.horizontal.calendar.library.extensions.onSingleClickListener

internal class WeekViewHolder(
    private val binding: ItemWeekBinding,
    private val listener: (day: Day) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(week: Week) {
        binding.mondayDV.apply {
            setDay(week.days[Week.INDEX_OF_MONDAY])
            onSingleClickListener { listener(week.days[Week.INDEX_OF_MONDAY]) }
        }

        binding.tuesdayDV.apply {
            setDay(week.days[Week.INDEX_OF_TUESDAY])
            onSingleClickListener { listener(week.days[Week.INDEX_OF_TUESDAY]) }
        }

        binding.wednesdayDV.apply {
            setDay(week.days[Week.INDEX_OF_WEDNESDAY])
            onSingleClickListener { listener(week.days[Week.INDEX_OF_WEDNESDAY]) }
        }

        binding.thursdayDV.apply {
            setDay(week.days[Week.INDEX_OF_THURSDAY])
            onSingleClickListener { listener(week.days[Week.INDEX_OF_THURSDAY]) }
        }

        binding.fridayDV.apply {
            setDay(week.days[Week.INDEX_OF_FRIDAY])
            onSingleClickListener { listener(week.days[Week.INDEX_OF_FRIDAY]) }
        }

        binding.saturdayDV.apply {
            setDay(week.days[Week.INDEX_OF_SATURDAY])
            onSingleClickListener { listener(week.days[Week.INDEX_OF_SATURDAY]) }
        }

        binding.sundayDV.apply {
            setDay(week.days[Week.INDEX_OF_SUNDAY])
            onSingleClickListener { listener(week.days[Week.INDEX_OF_SUNDAY]) }
        }
    }

}