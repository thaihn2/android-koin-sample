package com.example.koinsample.di

import com.example.koinsample.ui.main.MainContract
import com.example.koinsample.ui.main.MainPresenter
import com.example.koinsample.ui.splash.SplashContract
import com.example.koinsample.ui.splash.SplashPresenter
import org.koin.dsl.module.module

val activityModule = module(override = true) {
    factory<SplashContract.Presenter> { (view: SplashContract.View) -> SplashPresenter(view) }

    factory<MainContract.Presenter> { (view: MainContract.View) -> MainPresenter(view) }
}
