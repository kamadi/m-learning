package kz.kamadi.mlearning.extension

import android.content.res.ColorStateList
import android.graphics.drawable.*
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Build
import java.util.*

fun getAdaptiveRippleDrawable(normalColor: Int, pressedColor: Int): Drawable {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        RippleDrawable(
            ColorStateList.valueOf(pressedColor),
            null, getRippleMask(normalColor)
        )
    } else {
        getStateListDrawable(normalColor, pressedColor)
    }
}

private fun getRippleMask(color: Int): Drawable {
    val outerRadii = FloatArray(8)
    // 3 is radius of final ripple_round_15dp,
    // instead of 3 you can give required final radius
    Arrays.fill(outerRadii, 3f)

    val r = RoundRectShape(outerRadii, null, null)
    val shapeDrawable = ShapeDrawable(r)
    shapeDrawable.paint.color = color
    return shapeDrawable
}

fun getStateListDrawable(
    normalColor: Int, pressedColor: Int
): StateListDrawable {
    val states = StateListDrawable()
    states.addState(
        intArrayOf(android.R.attr.state_pressed),
        ColorDrawable(pressedColor)
    )
    states.addState(
        intArrayOf(android.R.attr.state_focused),
        ColorDrawable(pressedColor)
    )
    states.addState(
        intArrayOf(android.R.attr.state_activated),
        ColorDrawable(pressedColor)
    )
    states.addState(
        intArrayOf(),
        ColorDrawable(normalColor)
    )
    return states
}