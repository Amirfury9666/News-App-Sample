package com.fury.newsappsample.domain.repository

import androidx.lifecycle.LiveData
import com.fury.newsappsample.domain.datasource.NewsDataSource
import com.fury.newsappsample.domain.db.dao.NewsArticleDao
import com.fury.newsappsample.domain.db.entity.NewsEntity
import com.fury.newsappsample.response.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsRepositoryImpl(private val newsArticleDao: NewsArticleDao,private val newsDataSource : NewsDataSource) : NewsRepository {

    init {
        newsDataSource.downloadedNewsResponse.observeForever {
            persistFetchedNewsResponse(it)
        }
    }

    override suspend fun getNewsData(): LiveData<NewsEntity> {
        return withContext(Dispatchers.IO){
            return@withContext newsArticleDao.getAllArticles()
        }
    }

    override suspend fun fetchNews() {
        newsDataSource.fetchNewsData()
    }


    private fun persistFetchedNewsResponse(fetchedNewsResponse : NewsResponse){
        GlobalScope.launch(Dispatchers.IO){
            val entity = NewsEntity()
            entity.articleList = fetchedNewsResponse.articles
            newsArticleDao.insertArticles(entity)
        }
    }
}