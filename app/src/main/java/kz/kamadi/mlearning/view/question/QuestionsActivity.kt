package kz.kamadi.mlearning.view.question

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_questions.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.model.DataManager
import kz.kamadi.mlearning.model.Topic

class QuestionsActivity : AppCompatActivity() {

    private var topic: Topic? = null

    companion object {

        private const val TOPIC = "topic"

        fun start(context: Context, topic: Topic) {
            context.startActivity(Intent(context, QuestionsActivity::class.java).apply {
                putExtra(TOPIC, topic)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        topic = intent.extras?.getParcelable(TOPIC)
        title = topic?.title
        recyclerView.isNestedScrollingEnabled = false
        if (topic != null) {
            val questions = DataManager.questions[topic!!.id]
            if (questions != null) {
                recyclerView.adapter = QuestionAdapter(questions)
            }
        }
    }
}