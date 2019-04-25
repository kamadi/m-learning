package kz.kamadi.mlearning.extension

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.core.hardware.fingerprint.FingerprintManagerCompat

fun Context.showToast(@StringRes message: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.inflate(@LayoutRes layoutId: Int, root: ViewGroup, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(this).inflate(layoutId, root, attachToRoot)
}

val Context.isNetworkConnected: Boolean
    @SuppressLint("MissingPermission")
    get() {
        try {
            val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            if (Build.VERSION.SDK_INT < 23) {
                val networkInfo = cm.activeNetworkInfo
                if (networkInfo != null) {
                    return networkInfo.isConnected && (networkInfo.type == ConnectivityManager.TYPE_WIFI || networkInfo.type == ConnectivityManager.TYPE_MOBILE)
                }
            } else {
                val activeNetwork = cm.activeNetwork
                if (activeNetwork != null) {
                    val nc = cm.getNetworkCapabilities(activeNetwork)
                    return nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(
                        NetworkCapabilities.TRANSPORT_WIFI
                    )
                }
            }
        } catch (e: Exception) {
        }
        return false
    }

fun Context.showKeyboard(view: View) {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}

fun Activity.hideKeyboard() {
    val view = currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun Context.getPixel(dp: Float) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)

fun Context.getPixel(dp: Int) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics).toInt()

fun Int.toPixel(context: Context?) = context?.getPixel(this) ?: 0

fun Float.toPixel(context: Context?) = context?.getPixel(this) ?: 0

@SuppressLint("MissingPermission")
fun Context.vibrate(duration: Long) {
    val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        v.vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        v.vibrate(duration)
    }
}

val Context.isFingerprintAvailable: Boolean
    get() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return FingerprintManagerCompat.from(this).isFingerprintAuthAvailable
        }
        return false
    }
val FingerprintManagerCompat.isFingerprintAuthAvailable: Boolean
    @SuppressLint("MissingPermission")
    get() = isHardwareDetected && hasEnrolledFingerprints()