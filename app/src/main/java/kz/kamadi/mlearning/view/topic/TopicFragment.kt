package kz.kamadi.mlearning.view.topic

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_topic.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.extension.inTransaction
import kz.kamadi.mlearning.extension.supportActionBar
import kz.kamadi.mlearning.model.Topic
import kz.kamadi.mlearning.view.BaseFragment
import kz.kamadi.mlearning.view.question.QuestionsFragment

class TopicFragment : BaseFragment() {

    private var topic: Topic? = null

    companion object {

        private const val TOPIC = "topic"

        fun newInstance(topic: Topic): TopicFragment {
            return TopicFragment().apply {
                arguments = bundleOf(Pair(TOPIC, topic))
            }
        }
    }

    override val layoutId = R.layout.activity_topic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        topic = arguments?.getParcelable(TOPIC)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        supportActionBar?.title = topic?.title
        if (topic != null) {
            if (topic?.content.isNullOrEmpty()) {
                webView.loadUrl("file:///android_asset/${topic!!.id}.html")
            } else {
                webView.loadDataWithBaseURL("", topic?.content, "text/html", "UTF-8", "")
            }
        }
        nextButton.setOnClickListener {
            if (topic != null) {
                activity?.supportFragmentManager?.inTransaction {
                    replace(R.id.root, QuestionsFragment.newInstance(topic!!))
                    addToBackStack(null)
                }
            }
        }
    }
}