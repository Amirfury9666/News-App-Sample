package com.fury.newsappsample.domain.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fury.newsappsample.base.network.ApiService
import com.fury.newsappsample.response.NewsResponse
import com.fury.newsappsample.util.printError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class NewsDataSourceImpl(private val apiService: ApiService) : NewsDataSource {

    private var _downloadedNewsResponse = MutableLiveData<NewsResponse>()

    override val downloadedNewsResponse: LiveData<NewsResponse>
        get() = _downloadedNewsResponse

    override suspend fun fetchNewsData() {
        withContext(Dispatchers.Main){
            try {
                val fetchedNewsResponse = apiService.fetchNewsDataAsync().await()
                _downloadedNewsResponse.value = fetchedNewsResponse
            }catch (e : IOException){
                printError("Connectivity","No Internet Connection")
            }
        }
    }
}