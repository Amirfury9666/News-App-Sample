package com.fury.newsappsample.domain.repository

import androidx.lifecycle.LiveData
import com.fury.newsappsample.domain.db.entity.NewsEntity
import com.fury.newsappsample.response.NewsResponse

interface NewsRepository {
    suspend fun getNewsData()  : LiveData<NewsEntity>
    suspend fun fetchNews()
}