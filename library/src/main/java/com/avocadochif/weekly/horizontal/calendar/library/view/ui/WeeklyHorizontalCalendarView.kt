package com.avocadochif.weekly.horizontal.calendar.library.view.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.avocadochif.weekly.horizontal.calendar.library.R
import com.avocadochif.weekly.horizontal.calendar.library.databinding.ViewWeeklyHorizontalCalendarBinding
import com.avocadochif.weekly.horizontal.calendar.library.entity.Day
import com.avocadochif.weekly.horizontal.calendar.library.entity.DayViewStyle
import com.avocadochif.weekly.horizontal.calendar.library.entity.Week
import com.avocadochif.weekly.horizontal.calendar.library.utils.generators.WeeksGenerator
import com.avocadochif.weekly.horizontal.calendar.library.view.recyclerview.adapter.WeekAdapter
import com.avocadochif.weekly.horizontal.calendar.library.view.recyclerview.listener.OnScrollListener

class WeeklyHorizontalCalendarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ViewWeeklyHorizontalCalendarBinding.inflate(LayoutInflater.from(context), this, true)
    }

    private val attributes by lazy(LazyThreadSafetyMode.NONE) {
        context.obtainStyledAttributes(attrs, R.styleable.WeeklyHorizontalCalendarView)
    }

    private var countOfAvailableWeeksInPast: Int = 0
    private var countOfAvailableWeeksInFuture: Int = 0

    private var weeks: MutableList<Week> = mutableListOf()

    private val adapter = WeekAdapter(
        onDaySelected = { day ->
            updateDayViewsAfterSelection(day)
            onDaySelected(day.timestamp)
        }
    )

    var onDaySelected: (timestamp: Long) -> Unit = {}
    var onWeekChanged: (timestampOfFirstDayInWeek: Long, timestampOfLastDayInWeek: Long) -> Unit = { _, _ -> }

    init {
        initAttributes()
        initWeeks()
        initWeeksRV()
    }

    private fun initAttributes() {
        countOfAvailableWeeksInPast =
            attributes.getInteger(R.styleable.WeeklyHorizontalCalendarView_weekly_count_of_available_weeks_in_past, 0)
        countOfAvailableWeeksInFuture =
            attributes.getInteger(R.styleable.WeeklyHorizontalCalendarView_weekly_count_of_available_weeks_in_future, 0)
    }

    private fun initWeeks() {
        weeks.clear()
        weeks.addAll(
            WeeksGenerator.generateWeeksBasedOnCountOfAvailableWeeksInPastAndFuture(
                countOfAvailableWeeksInPast,
                countOfAvailableWeeksInFuture
            ).onEach { week ->
                week.days.forEach { it.style = getDayStyle() }
            }
        )
    }

    private fun initWeeksRV() {
        binding.weeksRV.apply {
            setHasFixedSize(true)
            adapter = this@WeeklyHorizontalCalendarView.adapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            PagerSnapHelper().attachToRecyclerView(this)
            addOnScrollListener(OnScrollListener(
                onScrolled = { index ->
                    onWeekChanged(weeks[index].days.first().timestamp, weeks[index].days.last().timestamp)
                }
            ))
        }
        adapter.submitList(weeks)
    }

    private fun getDayStyle(): DayViewStyle {
        return DayViewStyle(
            selectedBackgroundResId = attributes.getResourceId(
                R.styleable.WeeklyHorizontalCalendarView_weekly_selected_day_background_res_id,
                R.drawable.bg_rectangle_green_1_rounded_24
            ),
            unselectedBackgroundResId = attributes.getResourceId(
                R.styleable.WeeklyHorizontalCalendarView_weekly_unselected_day_background_res_id,
                R.drawable.bg_rectangle_transparent_rounded_24
            ),
            selectedTitleColorResId = attributes.getResourceId(
                R.styleable.WeeklyHorizontalCalendarView_weekly_selected_day_title_color_res_id,
                R.color.white
            ),
            unselectedTitleColorResId = attributes.getResourceId(
                R.styleable.WeeklyHorizontalCalendarView_weekly_unselected_day_title_color_res_id,
                R.color.grey_1
            ),
            selectedValueColorResId = attributes.getResourceId(
                R.styleable.WeeklyHorizontalCalendarView_weekly_selected_day_value_color_res_id,
                R.color.white
            ),
            unselectedValueColorResId = attributes.getResourceId(
                R.styleable.WeeklyHorizontalCalendarView_weekly_unselected_day_value_color_res_id,
                R.color.black
            ),
            titleFontResId = attributes.getResourceId(
                R.styleable.WeeklyHorizontalCalendarView_weekly_day_title_font_res_id,
                R.font.roboto_regular
            ),
            valueFontResId = attributes.getResourceId(
                R.styleable.WeeklyHorizontalCalendarView_weekly_day_value_font_res_id,
                R.font.roboto_medium
            )
        )
    }

    private fun updateDayViewsAfterSelection(day: Day) {
        mutableListOf<Week>().apply {
            weeks.forEach { add(it.copy()) }
        }.also { weeks ->
            weeks.firstOrNull { week -> week.days.any { it.isSelected } }?.let { week ->
                week.days.firstOrNull { it.isSelected }?.let { day ->
                    day.isSelected = false
                }
            }
        }.also { weeks ->
            weeks.firstOrNull { week -> week.days.any { it.timestamp == day.timestamp } }?.let { week ->
                week.days.firstOrNull { it.timestamp == day.timestamp }?.let { day ->
                    day.isSelected = true
                }
            }
        }.also {
            adapter.submitList(it)
            weeks = it
        }
    }

}