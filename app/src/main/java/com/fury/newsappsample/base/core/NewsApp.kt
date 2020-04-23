package com.fury.newsappsample.base.core

import android.app.Application
import com.fury.newsappsample.base.network.ConnectivityInterceptor
import com.fury.newsappsample.base.network.ConnectivityInterceptorImpl
import com.fury.newsappsample.base.network.ServiceGenerator
import com.fury.newsappsample.domain.datasource.NewsDataSource
import com.fury.newsappsample.domain.datasource.NewsDataSourceImpl
import com.fury.newsappsample.domain.db.NewsDatabase
import com.fury.newsappsample.domain.repository.NewsRepository
import com.fury.newsappsample.domain.repository.NewsRepositoryImpl
import com.fury.newsappsample.viewmodelfactory.ViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class NewsApp  : Application(),KodeinAware{
    override val kodein = Kodein.lazy {
        import(androidXModule(this@NewsApp))

        bind() from singleton { NewsDatabase(instance()) }
        bind() from singleton { instance<NewsDatabase>().getNewsArticleDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ServiceGenerator() }
        bind<NewsDataSource>() with singleton { NewsDataSourceImpl(instance()) }
        bind<NewsRepository>() with singleton { NewsRepositoryImpl(instance(),instance()) }

        bind() from provider {
            ViewModelFactory(instance())
        }
    }


}