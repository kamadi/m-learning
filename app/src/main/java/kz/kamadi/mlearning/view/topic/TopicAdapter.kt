package kz.kamadi.mlearning.view.topic

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_chapter.view.*
import kz.kamadi.mlearning.R
import kz.kamadi.mlearning.extension.inflate
import kz.kamadi.mlearning.model.DataManager
import kz.kamadi.mlearning.model.Topic

class TopicAdapter(
    private val topics: List<Topic>,
    private val onItemClickListener: (Topic) -> Unit
) : RecyclerView.Adapter<TopicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        return TopicViewHolder(parent.inflate(R.layout.item_topic), onItemClickListener)
    }

    override fun getItemCount(): Int = topics.size

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.bind(topics[position])
    }
}

class TopicViewHolder(
    itemView: View,
    private val onItemClickListener: (Topic) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private var topic: Topic? = null

    init {
        itemView.titleTextView.setOnClickListener {
            if (topic != null) {
                onItemClickListener(topic!!)
            }
        }
    }

    fun bind(topic: Topic) {
        this.topic = topic
        itemView.titleTextView.text = topic.title
        itemView.titleTextView.setCompoundDrawablesWithIntrinsicBounds(
            0,
            0,
            if (DataManager.topicResults[topic.id] != null) {
                R.drawable.ic_check_black_24dp
            } else {
                R.drawable.ic_next_grey
            },
            0
        )
    }
}