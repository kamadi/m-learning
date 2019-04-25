package kz.kamadi.mlearning.extension

import android.graphics.Typeface
import android.os.Build
import android.text.Html
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.util.Base64
import androidx.annotation.ColorInt

fun String.fromHtml(): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(this)
    }
}

fun String.removeNonDigits() = this.replace("[^0-9.]".toRegex(), "")

fun String.toPhoneFormat(): String {
    return when (length) {
        11 -> "+7 (${this.substring(1, 4)}) ${this.substring(4, 7)}-${this.substring(7, 9)}-${this.substring(9, 11)}"
        10 -> "+7 (${this.substring(0, 3)}) ${this.substring(3, 6)}-${this.substring(6, 8)}-${this.substring(8, 10)}"
        else -> this
    }
}

fun SpannableStringBuilder.addTextSpan(
    text: String, @ColorInt color: Int? = null,
    isBold: Boolean = false, textSize: Int = -1
): SpannableStringBuilder {
    append(text)
    if (color != null) {
        setSpan(ForegroundColorSpan(color), length - text.length, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
    if (isBold) {
        setSpan(StyleSpan(Typeface.BOLD), length - text.length, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
    if (textSize != -1) {
        setSpan(
            AbsoluteSizeSpan(textSize),
            length - text.length,
            length,
            Spanned.SPAN_INCLUSIVE_INCLUSIVE
        )
    }
    return this
}

fun SpannableStringBuilder.addTextSizeSpan(text: String?, textSize: Int): SpannableStringBuilder {
    append(" $text")
    if (text != null) {
        setSpan(
            AbsoluteSizeSpan(textSize),
            length - text.length,
            length,
            Spanned.SPAN_INCLUSIVE_INCLUSIVE
        )
    }
    return this
}

fun SpannableStringBuilder.addTextSizeRelativeSpan(
    text: String?,
    proportion: Float = 0.75f,
    @ColorInt color: Int? = null
): SpannableStringBuilder {
    append(" $text")
    if (text != null) {
        setSpan(
            RelativeSizeSpan(proportion),
            length - text.length,
            length,
            Spanned.SPAN_INCLUSIVE_INCLUSIVE
        )
        if (color != null) {
            setSpan(ForegroundColorSpan(color), length - text.length, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }
    return this
}

fun String.decodePin(): String {
    return String(Base64.decode(this, Base64.DEFAULT)).substring(0, 4)
}