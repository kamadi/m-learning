package kz.kamadi.mlearning.view.chapter

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_questions.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.extension.inTransaction
import kz.kamadi.mlearning.extension.showMessage
import kz.kamadi.mlearning.extension.supportActionBar
import kz.kamadi.mlearning.helper.Analyzer
import kz.kamadi.mlearning.model.Chapter
import kz.kamadi.mlearning.model.DataManager
import kz.kamadi.mlearning.model.Question
import kz.kamadi.mlearning.model.QuestionResult
import kz.kamadi.mlearning.view.BaseFragment
import kz.kamadi.mlearning.view.question.QuestionAdapter

class ChapterExamFragment : BaseFragment() {

    private var chapter: Chapter? = null

    private var questions: List<Question>? = null

    companion object {

        private const val CHAPTER = "chapter"

        fun newIntance(chapter: Chapter): ChapterExamFragment {
            return ChapterExamFragment().apply {
                arguments = bundleOf(Pair(CHAPTER, chapter))
            }
        }
    }

    override val layoutId = R.layout.fragment_chapter_exam

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chapter = arguments?.getParcelable(CHAPTER)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        supportActionBar?.title = chapter?.title
        if (chapter != null) {
            recyclerView.adapter = QuestionAdapter(chapter!!.questions)
        }
        questions = chapter?.questions
        sendButton.setOnClickListener {
            if (questions != null) {
                var total = 0.0
                val results = mutableListOf<QuestionResult>()

                for (i in 0 until questions!!.size) {
                    val q = questions!![i]
                    if (q.hasAnswer) {
                        val percent = q.finalPercent
                        Log.e(q.question, percent.toString())
                        results.add(
                            QuestionResult(q, percent)
                        )
                        total += percent
                    } else {
                        container.showMessage(R.string.fill_all_question)
                        break
                    }
                }
                if (results.size == questions!!.size) {
                    Log.e("total", (total / questions!!.size).toString())
                    DataManager.chapterExamResults[chapter!!.id] = results
                    activity?.inTransaction {
                        replace(
                            R.id.root,
                            QuestionResultFragment.newInstance(chapter!!, total / questions!!.size)
                        )
                        addToBackStack(null)
                    }
                }
            }
        }
    }
}