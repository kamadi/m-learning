package kz.kamadi.mlearning.view.question

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.model.Question
import kz.kamadi.mlearning.model.QuestionType

class QuestionView : LinearLayout {

    private lateinit var titleTextView: TextView

    private var answerButtons = listOf<Button>()

    private var question: Question? = null

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(attrs)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        inflate(context, R.layout.view_question, this)
        titleTextView = findViewById(R.id.titleTextView)
        answerButtons = listOf(
            findViewById(R.id.answer1Button),
            findViewById(R.id.answer2Button),
            findViewById(R.id.answer3Button),
            findViewById(R.id.answer4Button)
        )
        for (i in 0 until answerButtons.size) {
            answerButtons[i].setOnClickListener(ClickListener(i))
        }
    }

    fun setQuestion(question: Question) {
        this.question = question
        titleTextView.text = question.question
        for (i in 0 until answerButtons.size) {
            answerButtons[i].text = question.answers.getOrNull(i)
        }
    }

    private fun validateAnswer() {
        if (question != null) {
            if (question!!.type == QuestionType.DEFAULT) {
                question?.userAnswerIndex = answerButtons.indexOfFirst { it.isSelected }
            } else if (question!!.type == QuestionType.MULTIPLE) {
                val indexes = mutableListOf<Int>()
                for (i in 0 until answerButtons.size) {
                    if (answerButtons[i].isSelected) {
                        indexes.add(i)
                    }
                }
                question?.userAnswerIndexes = indexes
            }
        }
    }

    private inner class ClickListener(val index: Int) : OnClickListener {

        private val button = answerButtons[index]

        override fun onClick(v: View?) {
            button.isSelected = !button.isSelected
            if (question?.type == QuestionType.DEFAULT && button.isSelected) {
                for (i in 0 until answerButtons.size) {
                    if (i != index) {
                        answerButtons[i].isSelected = false
                    }
                }
            }
            validateAnswer()
        }
    }
}