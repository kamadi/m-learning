package kz.kamadi.mlearning.view.question

import android.content.Context
import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.isGone
import androidx.core.view.isVisible
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.model.Question
import kz.kamadi.mlearning.model.QuestionType

class QuestionView : LinearLayout, TextWatcher {

    private lateinit var titleTextView: TextView

    private lateinit var answerEditText: EditText

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
        answerEditText = findViewById(R.id.answerEditText)
        answerEditText.addTextChangedListener(this)
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


    override fun afterTextChanged(s: Editable?) {
        question?.userAnswer = s?.toString()
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    fun setQuestion(question: Question) {
        this.question = question
        titleTextView.text = question.question
        for (i in 0 until answerButtons.size) {
            answerButtons[i].text = question.answers.getOrNull(i)
            answerButtons[i].isGone = question.type == QuestionType.OPEN
        }
        answerEditText.isVisible = question.type == QuestionType.OPEN
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