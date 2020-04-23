package com.fury.newsappsample.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fury.newsappsample.domain.repository.NewsRepository
import com.fury.newsappsample.viewmodel.NewsViewModel

class ViewModelFactory(private val newsRepository: NewsRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass){
            when{
                isAssignableFrom(NewsViewModel::class.java) -> NewsViewModel(newsRepository)
                else -> error("Invalid ViewModel")
            } as T
        }
}