package com.fury.newsappsample.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.fury.newsappsample.R
import com.fury.newsappsample.adapter.NewsAdapter
import com.fury.newsappsample.base.core.BaseActivity
import com.fury.newsappsample.databinding.ActivityHomeBinding
import com.fury.newsappsample.viewmodel.NewsViewModel
import com.fury.newsappsample.viewmodelfactory.ViewModelFactory
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class HomeActivity : BaseActivity<ActivityHomeBinding>(),KodeinAware {
    override val kodein: Kodein by kodein()
    private val _factory : ViewModelFactory by instance()
    private lateinit var newsViewModel : NewsViewModel

    private var mNewsAdapter = NewsAdapter()
    override val layoutRes: Int get() = R.layout.activity_home
    override fun getToolbar(binding: ActivityHomeBinding): Toolbar? {return binding.toolbar}
    override fun onActivityReady(instanceState: Bundle?, binding: ActivityHomeBinding) {
        newsViewModel = ViewModelProviders.of(this,_factory).get(NewsViewModel::class.java)
        binding.newsRecycler.adapter = mNewsAdapter
        bindUI(binding)
    }

    private fun bindUI(binding: ActivityHomeBinding) = launch {
        val news = newsViewModel.news.await()
        news.observe(this@HomeActivity, Observer {
            it?.articleList?.let {
                mNewsAdapter.submitList(it)
            }
        })
    }

}
