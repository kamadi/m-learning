package kz.kamadi.mlearning.model

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question(
    val question: String,
    val answers: List<String>,
    val rightAnswerIndexes: List<Int>,
    val difficulty: QuestionDifficulty = QuestionDifficulty.EASY,
    val type: QuestionType = QuestionType.DEFAULT
) : Parcelable {

    @IgnoredOnParcel
    var userAnswerIndex = -1

    @IgnoredOnParcel
    var userAnswerIndexes = emptyList<Int>()

    val finalPercent: Double
        get() {
            if (type == QuestionType.DEFAULT && rightAnswerIndexes[0] == userAnswerIndex) {
                return 1.0
            }
            if (type == QuestionType.MULTIPLE) {
                if (userAnswerIndexes.size <= rightAnswerIndexes.size) {
                    var count = 0
                    userAnswerIndexes.forEach { index ->
                        val i = rightAnswerIndexes.indexOfFirst { it == index }
                        if (i != -1) {
                            count++
                        }
                    }
                    return (count * 1.0) / rightAnswerIndexes.size
                }
            }
            return .0
        }

    val hasAnswer: Boolean
        get() = userAnswerIndexes.isNotEmpty() || userAnswerIndex != -1
}

data class QuestionResult(
    val question: Question,
    val percent: Double
)

enum class QuestionType {
    DEFAULT, OPEN, MULTIPLE
}

enum class QuestionDifficulty(weight: Int) {
    HARD(1), MEDIUM(2), EASY(3), TOPIC(1)
}