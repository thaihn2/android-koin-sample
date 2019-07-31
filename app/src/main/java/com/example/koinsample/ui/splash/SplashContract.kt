package com.example.koinsample.ui.splash

interface SplashContract {

    interface View {
        fun gotoMain()
    }

    interface Presenter {
        fun onViewCreated()
        fun onViewDestroyed()
    }
}
