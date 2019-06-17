package kz.kamadi.mlearning.view.chapter

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_chapter.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.extension.inTransaction
import kz.kamadi.mlearning.extension.supportActionBar
import kz.kamadi.mlearning.model.DataManager
import kz.kamadi.mlearning.view.BaseFragment
import kz.kamadi.mlearning.view.topic.TopicsFragment

class ChapterFragment : BaseFragment() {

    override val layoutId = R.layout.activity_chapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        supportActionBar?.title = getString(R.string.app_name)
        val chapters = DataManager.chapters.map { it.value }
        recyclerView.adapter = ChapterAdapter(chapters) {
            requireActivity().supportFragmentManager.inTransaction {
                replace(R.id.root, TopicsFragment.newInstance(it))
                addToBackStack(TopicsFragment::class.java.simpleName)
            }
        }
    }
}