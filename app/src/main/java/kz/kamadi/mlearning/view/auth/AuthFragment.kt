package kz.kamadi.mlearning.view.auth

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_auth.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.view.BaseFragment

class AuthFragment : BaseFragment() {

    override val layoutId = R.layout.fragment_auth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pager.adapter = AuthFragmentAdapter(childFragmentManager)
        tabLayout.setupWithViewPager(pager)
    }
}