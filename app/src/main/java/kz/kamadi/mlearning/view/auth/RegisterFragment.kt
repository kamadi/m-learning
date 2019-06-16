package kz.kamadi.mlearning.view.auth

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_register.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.extension.inTransaction
import kz.kamadi.mlearning.view.BaseFragment
import kz.kamadi.mlearning.view.chapter.ChapterFragment

class RegisterFragment : BaseFragment() {

    override val layoutId = R.layout.fragment_register

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerButton.setOnClickListener {
            requireActivity().supportFragmentManager.inTransaction {
                replace(R.id.root, ChapterFragment())
            }
        }
    }
}