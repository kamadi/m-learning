package kz.kamadi.mlearning.extension

import androidx.annotation.DrawableRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.*
import androidx.lifecycle.Lifecycle
import kz.kamadi.mlearning.R

val FragmentManager.isEmpty: Boolean
    get() = backStackEntryCount == 0

val FragmentManager.isNotEmpty: Boolean
    get() = backStackEntryCount > 0

val FragmentActivity.canPerformTransaction: Boolean
    get() = lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)

val Fragment.canPerformTransaction: Boolean?
    get() = activity?.lifecycle?.currentState?.isAtLeast(Lifecycle.State.RESUMED)

inline fun FragmentActivity.inTransaction(func: FragmentTransaction.() -> Unit) {
    if (canPerformTransaction) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }
}

fun FragmentActivity.popBackStack() {
    if (canPerformTransaction) {
        supportFragmentManager.popBackStack()
    }
}

fun Fragment.goBack(): Boolean {
    if (canPerformTransaction == true && childFragmentManager.isNotEmpty) {
        childFragmentManager.popBackStack()
        return false
    }
    return true
}

fun Fragment.backToRoot(): Boolean {
    if (canPerformTransaction == true && childFragmentManager.isNotEmpty) {
        childFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        return false
    }
    return true
}

fun DialogFragment.show(fragment: Fragment?) {
    if (fragment?.canPerformTransaction == true) {
        show(fragment.childFragmentManager, javaClass.simpleName)
    }
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
}

fun FragmentManager.clearStack() {
    popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
}

fun Fragment.setSupportActionBar(toolbar: Toolbar?, @DrawableRes navigationIcon: Int?) {
    if (activity is AppCompatActivity) {
        if (navigationIcon != null) {
            toolbar?.setNavigationIcon(navigationIcon)
        }
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.title = null
    }
}

inline val Fragment.supportActionBar: ActionBar?
    get() {
        return (activity as? AppCompatActivity)?.supportActionBar
    }

fun Fragment.showBackButton() {
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setHomeButtonEnabled(true)
}

