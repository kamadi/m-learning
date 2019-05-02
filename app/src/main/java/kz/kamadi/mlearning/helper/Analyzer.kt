package kz.kamadi.mlearning.helper

import android.util.Log
import kz.kamadi.mlearning.model.Chapter
import kz.kamadi.mlearning.model.DataManager
import kz.kamadi.mlearning.model.Topic

private const val TOPIC_PASS_RESULT = 0.8

object Analyzer {

    fun analyze(chapter: Chapter): List<Topic> {
        val topics = DataManager.topics[chapter.id]
        val chapterExam = DataManager.chapterExamResults[chapter.id]
        val failedTopics = mutableListOf<Topic>()
        if (topics != null && chapterExam != null) {
            for (topic in topics) {
                val topicResult = DataManager.topicResults[topic.id]
                if (topicResult != null) {
                    var total = topicResult.sumByDouble { it.question.difficulty.weight }
                    var user = topicResult.sumByDouble {
                        it.percent * it.question.difficulty.weight
                    }
                    val chapterExamTopic = chapterExam.filter { it.question.topicId == topic.id }
                    if (chapterExamTopic.isNotEmpty()) {
                        total += chapterExamTopic.sumByDouble { it.question.difficulty.weight }
                        user += chapterExamTopic.sumByDouble {
                            it.percent * it.question.difficulty.weight
                        }
                    }
                    Log.e("analyze", "${topic.title} total: $total user: $user")
                    if (user / total < TOPIC_PASS_RESULT) {
                        failedTopics.add(topic)
                    }
                }
            }
        }
        return failedTopics
    }
}