package com.avocadochif.weekly.horizontal.calendar.library.view.recyclerview.listener

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OnScrollListener(
    val onScrolled: (indexOfFirstVisibleItem: Int) -> Unit
) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        (recyclerView.layoutManager as? LinearLayoutManager)?.let { manager ->
            onScrolled(manager.findFirstVisibleItemPosition())
        }
    }

}