package com.fury.newsappsample.adapter

import androidx.recyclerview.widget.DiffUtil
import com.fury.newsappsample.R
import com.fury.newsappsample.base.core.BaseListAdapter
import com.fury.newsappsample.response.Article

class NewsAdapter : BaseListAdapter<Article>(DiffCallBack()) {

    private class DiffCallBack : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.title == newItem.title && oldItem.description == newItem.description && oldItem.urlToImage == newItem.urlToImage && oldItem.author == newItem.author
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.new_item
    }


}