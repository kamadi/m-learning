package kz.kamadi.mlearning.extension

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

fun SwipeRefreshLayout.setProgressViewOffsetByToolbar(toolbarHeight:Int){
    setProgressViewOffset(
        true,
        toolbarHeight,
        (toolbarHeight * 1.5).toInt()
    )
}