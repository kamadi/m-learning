package kz.kamadi.mlearning.view.chapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_chapter.view.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.extension.inflate
import kz.kamadi.mlearning.model.Chapter

class ChapterAdapter(
    private val chapters: List<Chapter>,
    private val onItemClickListener: (Chapter) -> Unit
) : RecyclerView.Adapter<ChapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        return ChapterViewHolder(parent.inflate(R.layout.item_chapter), onItemClickListener)
    }

    override fun getItemCount(): Int = chapters.size

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        holder.bind(chapters[position])
    }
}

class ChapterViewHolder(
    itemView: View,
    private val onItemClickListener: (Chapter) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private var chapter: Chapter? = null

    init {
        itemView.titleTextView.setOnClickListener {
            if (chapter != null) {
                onItemClickListener(chapter!!)
            }
        }
    }

    fun bind(chapter: Chapter) {
        this.chapter = chapter
        itemView.titleTextView.text = chapter.title
    }
}