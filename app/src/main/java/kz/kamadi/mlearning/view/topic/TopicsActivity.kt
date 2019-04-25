package kz.kamadi.mlearning.view.topic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_topics.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.model.Chapter
import kz.kamadi.mlearning.model.DataManager

class TopicsActivity : AppCompatActivity() {

    private var chapter: Chapter? = null

    companion object {

        private const val CHAPTER = "chapter"

        fun start(context: Context, chapter: Chapter) {
            context.startActivity(Intent(context, TopicsActivity::class.java).apply {
                putExtra(CHAPTER, chapter)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topics)
        chapter = intent.extras?.getParcelable(CHAPTER)
        if (chapter != null) {
            title = chapter?.title
            val topics = DataManager.topics[chapter!!.id]
            if (topics != null) {
                recyclerView.adapter = TopicAdapter(topics) {
                    TopicActivity.start(this, it)
                }
            }
        }
    }
}