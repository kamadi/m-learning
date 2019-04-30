package kz.kamadi.mlearning.view.topic

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_topics.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.extension.inTransaction
import kz.kamadi.mlearning.extension.supportActionBar
import kz.kamadi.mlearning.model.Chapter
import kz.kamadi.mlearning.model.DataManager
import kz.kamadi.mlearning.view.BaseFragment
import kz.kamadi.mlearning.view.chapter.ChapterExamFragment

class TopicsFragment : BaseFragment() {

    private var chapter: Chapter? = null

    companion object {

        private const val CHAPTER = "chapter"

        fun newInstance(chapter: Chapter): TopicsFragment {
            return TopicsFragment().apply {
                arguments = bundleOf(Pair(CHAPTER, chapter))
            }
        }
    }

    override val layoutId = R.layout.activity_topics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chapter = arguments?.getParcelable(CHAPTER)
        if (chapter != null) {
            supportActionBar?.title = chapter?.title
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val topics = DataManager.topics[chapter!!.id]
        if (topics != null) {
            recyclerView.adapter = TopicAdapter(topics) {
                activity?.inTransaction {
                    replace(R.id.root, TopicFragment.newInstance(it))
                    addToBackStack(null)
                }
            }
            var count = 0
            for (i in 0 until topics.size) {
                if (DataManager.topicResults.containsKey(topics[i].id)) {
                    count++
                }
            }
            passExamButton.isVisible = count == topics.size
        }
        passExamButton.setOnClickListener {
            if (chapter != null) {
                activity?.inTransaction {
                    replace(R.id.root, ChapterExamFragment.newIntance(chapter!!))
                    addToBackStack(null)
                }
            }
        }
    }
}