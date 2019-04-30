package kz.kamadi.mlearning.view.question

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_questions.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.extension.inTransaction
import kz.kamadi.mlearning.extension.showMessage
import kz.kamadi.mlearning.extension.supportActionBar
import kz.kamadi.mlearning.model.DataManager
import kz.kamadi.mlearning.model.Question
import kz.kamadi.mlearning.model.QuestionResult
import kz.kamadi.mlearning.model.Topic
import kz.kamadi.mlearning.view.BaseFragment

class QuestionsFragment : BaseFragment() {

    private var topic: Topic? = null

    private var questions: List<Question>? = null

    companion object {

        private const val TOPIC = "topic"

        fun newInstance(topic: Topic): QuestionsFragment {
            return QuestionsFragment().apply {
                arguments = bundleOf(Pair(TOPIC, topic))
            }
        }
    }

    override val layoutId = R.layout.activity_questions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        topic = arguments?.getParcelable(TOPIC)
        supportActionBar?.title = topic?.title
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.isNestedScrollingEnabled = false
        if (topic != null) {
            questions = DataManager.questions[topic!!.id]
            if (questions != null) {
                questions!!.forEach {
                    it.clear()
                }
                recyclerView.adapter = QuestionAdapter(questions!!)
            }
        }
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
                    DataManager.topicResults[topic!!.id] = results
                    activity?.inTransaction {
                        replace(
                            R.id.root,
                            QuestionResultFragment.newInstance(topic!!, total / questions!!.size)
                        )
                        addToBackStack(null)
                    }
                }
            }
        }
    }
}