package kz.kamadi.mlearning.view.question

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_question.view.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.extension.inflate
import kz.kamadi.mlearning.model.Question

class QuestionAdapter(
    private val questions: List<Question>
) : RecyclerView.Adapter<QuestionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        return QuestionViewHolder(parent.inflate(R.layout.item_question))
    }

    override fun getItemCount(): Int = questions.size

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(questions[position])
    }
}

class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var question: Question? = null

    fun bind(question: Question) {
        this.question = question
        itemView.questionView.setQuestion(question)
    }
}