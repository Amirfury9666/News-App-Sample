package com.fury.newsappsample.base.network

import android.content.Context
import android.net.ConnectivityManager
import com.fury.newsappsample.internel.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptorImpl(context: Context) : ConnectivityInterceptor {


    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!hashNetworkAvailable(context = appContext))
            throw NoConnectivityException()
        return chain.proceed(chain.request())
    }

    private fun hashNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return (activeNetwork != null && activeNetwork.isConnected)

    }
}