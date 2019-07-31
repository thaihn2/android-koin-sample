package com.example.koinsample.ui.splash

import android.content.Intent
import android.os.Bundle
import com.example.koinsample.R
import com.example.koinsample.base.ui.BaseActivity
import com.example.koinsample.ui.main.MainActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SplashActivity : BaseActivity(), SplashContract.View {

    private val splashPresenter: SplashContract.Presenter by inject { parametersOf(this) }

    override val layoutResource: Int
        get() = R.layout.activity_splash

    override fun initComponent(savedInstanceState: Bundle?) {
        splashPresenter.onViewCreated()
    }

    override fun gotoMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
