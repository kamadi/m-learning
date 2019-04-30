package kz.kamadi.mlearning

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import kz.kamadi.mlearning.extension.inTransaction
import kz.kamadi.mlearning.view.BaseFragment
import kz.kamadi.mlearning.view.chapter.ChapterFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.inTransaction {
            replace(R.id.root, ChapterFragment())
        }
    }

    override fun onBackPressed() {
        handleOnBackPressed()
    }

    private fun handleOnBackPressed(@IdRes id: Int = R.id.root) {
        val fragment = supportFragmentManager.findFragmentById(id)
        if (fragment == null) {
            finish()
        } else if (fragment is BaseFragment) {
            if (fragment.onBackPressed()) {
                handleBackStack()
            } else {
                return
            }
        } else {
            handleBackStack()
        }
    }

    private fun handleBackStack() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }
}
