package com.avocadochif.weekly.horizontal.calendar.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.avocadochif.weekly.horizontal.calendar.library.view.ui.WeeklyHorizontalCalendarView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    /**
     * @sample 'fri' 01
     */
    private val shortFormatOfDayAndMonth by lazy(LazyThreadSafetyMode.NONE) {
        SimpleDateFormat("E d", Locale.getDefault())
    }

    /**
     * @sample 'oct'
     **/
    private val shortFormatOfMonth: SimpleDateFormat by lazy(LazyThreadSafetyMode.NONE) {
        SimpleDateFormat("MMM", Locale.getDefault())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<WeeklyHorizontalCalendarView>(R.id.calendar)?.let {
            it.onDaySelected = { timestamp ->
                findViewById<TextView>(R.id.day)?.let { textView ->
                    textView.text = shortFormatOfDayAndMonth.format(timestamp)
                }
            }

            it.onWeekChanged = { timestampOfFirstDayInWeek, timestampOfLastDayInWeek ->
                findViewById<TextView>(R.id.month)?.let { textView ->
                    textView.text = "${shortFormatOfMonth.format(timestampOfFirstDayInWeek)}" +
                        " - " +
                        "${shortFormatOfMonth.format(timestampOfLastDayInWeek)}"
                }
            }
        }
    }

}