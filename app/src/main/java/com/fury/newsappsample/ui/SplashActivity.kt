package com.fury.newsappsample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.widget.Toolbar
import com.fury.newsappsample.R
import com.fury.newsappsample.base.core.BaseActivity
import com.fury.newsappsample.databinding.ActivitySplashBinding

private const val SPLASH_TIME_OUT = 1500L
class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override val layoutRes: Int get() = R.layout.activity_splash

    override fun getToolbar(binding: ActivitySplashBinding): Toolbar? {return null}

    override fun onActivityReady(instanceState: Bundle?, binding: ActivitySplashBinding) {

        Handler().postDelayed({
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }


}