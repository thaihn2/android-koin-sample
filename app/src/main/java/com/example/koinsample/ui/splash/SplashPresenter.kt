package com.example.koinsample.ui.splash

import android.os.Handler

class SplashPresenter(
        private var view: SplashContract.View
) : SplashContract.Presenter {

    companion object {
        private val TAG = SplashPresenter::class.java.simpleName

        private const val SPLASH_TIME = 2000L
    }

    override fun onViewCreated() {
        Handler().postDelayed({
            view.gotoMain()
        }, SPLASH_TIME)
    }

    override fun onViewDestroyed() {

    }
}
