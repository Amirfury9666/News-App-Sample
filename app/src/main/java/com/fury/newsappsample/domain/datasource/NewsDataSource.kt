package com.fury.newsappsample.domain.datasource

import androidx.lifecycle.LiveData
import com.fury.newsappsample.response.NewsResponse

interface NewsDataSource {
    val downloadedNewsResponse : LiveData<NewsResponse>
    suspend fun fetchNewsData()
}