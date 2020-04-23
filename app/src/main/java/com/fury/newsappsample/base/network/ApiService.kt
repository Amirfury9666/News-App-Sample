package com.fury.newsappsample.base.network


import com.fury.newsappsample.response.NewsResponse
import com.fury.newsappsample.util.Constants
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.API_URL + Constants.NEW_API_KEY)
    suspend fun fetchNews(): Response<NewsResponse>

    @GET(Constants.API_URL + Constants.NEW_API_KEY)
    fun fetchNewsDataAsync(): Deferred<NewsResponse>
}