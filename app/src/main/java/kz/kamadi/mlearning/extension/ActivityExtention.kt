package kz.kamadi.mlearning.extension

import android.app.Activity
import android.graphics.Point
import android.util.TypedValue

val Activity.deviceHeight: Int
    get() {
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.y - statusBarHeight
    }

val Activity.contentHeight: Int
    get() {
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.y - toolbarHeight - statusBarHeight
    }

val Activity.toolbarHeight: Int
    get() {
        val tv = TypedValue()
        if (theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            return TypedValue.complexToDimensionPixelSize(tv.data, resources.displayMetrics)
        }
        return 0
    }

val Activity.statusBarHeight: Int
    get() {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }
