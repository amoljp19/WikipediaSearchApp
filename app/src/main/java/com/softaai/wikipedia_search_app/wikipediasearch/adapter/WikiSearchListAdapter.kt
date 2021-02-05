package com.softaai.wikipedia_search_app.wikipediasearch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.softaai.wikipedia_search_app.R
import com.softaai.wikipedia_search_app.model.Page

class WikiSearchListAdapter : ListAdapter<Page, WikiSearchListAdapter.WikiSearchViewHolder>(WikiSearchComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WikiSearchViewHolder {
        return WikiSearchViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WikiSearchViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.title)
    }

    class WikiSearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val pageTitleItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            pageTitleItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): WikiSearchViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return WikiSearchViewHolder(view)
            }
        }
    }

    class WikiSearchComparator : DiffUtil.ItemCallback<Page>() {
        override fun areItemsTheSame(oldItem: Page, newItem: Page): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Page, newItem: Page): Boolean {
            return oldItem.title == newItem.title
        }
    }

}