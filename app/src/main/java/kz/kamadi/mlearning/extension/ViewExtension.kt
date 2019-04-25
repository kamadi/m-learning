package kz.kamadi.mlearning.extension

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import kz.kamadi.mlearning.R

fun View.showMessage(message: String?, duration: Int = Snackbar.LENGTH_SHORT) {
    if (!message.isNullOrEmpty()) {
        Snackbar.make(this, message, duration).show()
    }
}

fun View.showMessage(@StringRes message: Int, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, message, duration).show()
}

fun ViewGroup.inflate(@LayoutRes resource: Int, root: ViewGroup? = null, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(resource, root ?: this, attachToRoot)
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}