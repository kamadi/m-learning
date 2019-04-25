package kz.kamadi.mlearning.extension

import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView

fun EditText.setDoneClickListener(action: () -> Unit) {
    setOnEditorActionListener((TextView.OnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            action()
            return@OnEditorActionListener true
        }
        return@OnEditorActionListener false
    }))
}

val EditText.phoneNumber: String
    get() = text.toString().replace("[^0-9.]".toRegex(), "")

val EditText.isValidPhoneNumber: Boolean
    get() = phoneNumber.length == 11

val EditText.doubleValue: Double
    get() = this.text.toString().removeNonDigits().toDouble()

val EditText.intValue: Int
    get() = this.text.toString().removeNonDigits().toInt()