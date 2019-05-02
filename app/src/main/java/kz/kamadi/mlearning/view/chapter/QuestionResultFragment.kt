package kz.kamadi.mlearning.view.chapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_question_result.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.extension.backToRoot
import kz.kamadi.mlearning.extension.supportActionBar
import kz.kamadi.mlearning.helper.Analyzer
import kz.kamadi.mlearning.model.Chapter
import kz.kamadi.mlearning.model.Topic
import kz.kamadi.mlearning.view.BaseFragment
import kz.kamadi.mlearning.view.topic.TopicAdapter

class QuestionResultFragment : BaseFragment() {

    private var chapter: Chapter? = null

    private var topics: List<Topic>? = null

    companion object {

        private const val CHAPTER = "chapter"
        private const val RESULT = "result"

        fun newInstance(chapter: Chapter, result: Double): QuestionResultFragment {
            return QuestionResultFragment().apply {
                arguments = bundleOf(Pair(CHAPTER, chapter), Pair(RESULT, result))
            }
        }
    }

    override val layoutId = R.layout.activity_question_result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Test result"
        chapter = arguments?.getParcelable(CHAPTER)
        if (chapter != null) {
            topics = Analyzer.analyze(chapter!!)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getDouble(RESULT)?.let {
            resultTextView.text = "${it * 100} %"
        }
        nextButton.setOnClickListener {
            activity?.backToRoot()
        }
        if (!topics.isNullOrEmpty()) {
            failedTopicsTextView.isVisible = true
            recyclerView.adapter = TopicAdapter(topics!!, showFinished = false) {}
        }
    }
}