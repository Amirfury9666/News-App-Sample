package com.fury.newsappsample.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageLoader {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadArticleImage(imageView: ImageView,url : String?){
        url?.let {
            Glide.with(imageView.context).load(it).into(imageView)
        }
    }
}