package kz.kamadi.mlearning.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question(
    val question: String,
    val answers: List<String>,
    val difficulty: QuestionDifficulty = QuestionDifficulty.EASY,
    val type: QuestionType = QuestionType.DEFAULT
) : Parcelable

enum class QuestionType {
    DEFAULT, OPEN, MULTIPLE
}

enum class QuestionDifficulty(weight: Int) {
    HARD(1), MEDIUM(2), EASY(3), TOPIC(1)
}