package kz.kamadi.mlearning.view.topic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_topic.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.model.Topic
import kz.kamadi.mlearning.view.question.QuestionsActivity

class TopicActivity : AppCompatActivity() {

    private var topic: Topic? = null

    companion object {

        private const val TOPIC = "topic"

        fun start(context: Context, topic: Topic) {
            context.startActivity(Intent(context, TopicActivity::class.java).apply {
                putExtra(TOPIC, topic)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic)
        topic = intent.extras?.getParcelable(TOPIC)
        title = topic?.title
        contentTextView.text = topic?.content
        nextButton.setOnClickListener {
            if (topic != null) {
                QuestionsActivity.start(this, topic!!)
            }
        }
    }
}