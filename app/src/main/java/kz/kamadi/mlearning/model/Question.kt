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
    val type: QuestionType = QuestionType.DEFAULT,
    val topicId: Int? = null
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

    fun clear() {
        userAnswerIndex = -1
        userAnswerIndexes = listOf()
    }
}

data class QuestionResult(
    val question: Question,
    val percent: Double
)

enum class QuestionType {
    DEFAULT, OPEN, MULTIPLE
}

enum class QuestionDifficulty(val weight: Double) {
    HARD(1.0), MEDIUM(2.0), EASY(3.0), TOPIC(1.0)
}