package kz.kamadi.mlearning.view.question

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_question_result.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.extension.backToRoot
import kz.kamadi.mlearning.extension.round
import kz.kamadi.mlearning.extension.supportActionBar
import kz.kamadi.mlearning.model.Topic
import kz.kamadi.mlearning.view.BaseFragment

class QuestionResultFragment : BaseFragment() {

    companion object {

        private const val TOPIC = "topic"
        private const val RESULT = "result"

        fun newInstance(topic: Topic, result: Double): QuestionResultFragment {
            return QuestionResultFragment().apply {
                arguments = bundleOf(Pair(TOPIC, topic), Pair(RESULT, result))
            }
        }
    }

    override val layoutId = R.layout.activity_question_result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Test result"
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getDouble(RESULT)?.let {
            resultTextView.text = "${(it * 100).round()} %"
        }
        nextButton.setOnClickListener {
            activity?.backToRoot()
        }
    }
}