package com.fury.newsappsample.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.fury.newsappsample.R
import com.fury.newsappsample.base.core.BaseActivity
import com.fury.newsappsample.databinding.ActivityDetailsBinding
import com.fury.newsappsample.response.Article
import com.fury.newsappsample.util.ImageLoader

class DetailsActivity : BaseActivity<ActivityDetailsBinding>() {


    override val layoutRes: Int get() = R.layout.activity_details

    override fun getToolbar(binding: ActivityDetailsBinding): Toolbar? {return binding.toolbar}

    override fun onActivityReady(instanceState: Bundle?, binding: ActivityDetailsBinding) {
        setToolbarTitle("Details")
        enableBack()
        intent?.let {
           binding.title.text = it.getStringExtra("title")
            binding.content.text  = it.getStringExtra("content")
            ImageLoader.loadArticleImage(binding.articleImage,it.getStringExtra("image"))
        }

    }

}
