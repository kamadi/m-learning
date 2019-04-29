package kz.kamadi.mlearning.view.question

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_question_result.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.model.Topic

class QuestionResultActivity : AppCompatActivity() {

    companion object {

        private const val TOPIC = "topic"
        private const val RESULT = "result"

        fun start(context: Context, topic: Topic, result: Double) {
            context.startActivity(Intent(context, QuestionResultActivity::class.java).apply {
                putExtra(TOPIC, topic)
                putExtra(RESULT, result)
            })
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_result)
        title = "Test result"
        intent.extras?.getDouble(RESULT)?.let {
            resultTextView.text = "${it * 100} %"
        }
    }
}