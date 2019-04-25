package kz.kamadi.mlearning.extension

import android.graphics.Color
import android.os.Build
import androidx.annotation.ColorRes
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

fun Toolbar.setBackgroundByTopOffset(topOffset: Int, @ColorRes color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        if (topOffset == 0) {
            setBackgroundColor(Color.TRANSPARENT)
            elevation = 0f
        } else {
            setBackgroundColor(ContextCompat.getColor(context, color))
            elevation = context.getPixel(4).toFloat()
        }
    }
}