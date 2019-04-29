package kz.kamadi.mlearning.view.question

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_questions.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.extension.showMessage
import kz.kamadi.mlearning.model.DataManager
import kz.kamadi.mlearning.model.Question
import kz.kamadi.mlearning.model.QuestionResult
import kz.kamadi.mlearning.model.Topic

class QuestionsActivity : AppCompatActivity() {

    private var topic: Topic? = null

    private var questions: List<Question>? = null

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
            questions = DataManager.questions[topic!!.id]
            if (questions != null) {
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
                    DataManager.topicResults[topic!!] = results
                    QuestionResultActivity.start(this, topic!!, total / questions!!.size)
                }
            }
        }
    }
}