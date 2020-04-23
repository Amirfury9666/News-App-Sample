package com.fury.newsappsample.viewmodel

import androidx.lifecycle.ViewModel
import com.fury.newsappsample.domain.repository.NewsRepository
import com.fury.newsappsample.util.lazyDefered
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel(){

    init {
        fetchNews()
    }

    val news by lazyDefered {
        newsRepository.getNewsData()
    }

    fun fetchNews(){
        GlobalScope.launch {
            newsRepository.fetchNews()
        }
    }
}