package kz.kamadi.mlearning.view.chapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_chapter.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.model.DataManager
import kz.kamadi.mlearning.view.topic.TopicsActivity

class ChapterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter)
        recyclerView.adapter = ChapterAdapter(DataManager.chapters) {
            TopicsActivity.start(this,it)
        }
    }
}