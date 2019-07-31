package com.example.koinsample.ui.main

import com.example.koinsample.data.local.entity.UserEntity
import com.example.koinsample.repository.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class MainPresenter(
        private val view: MainContract.View
) : MainContract.Presenter, KoinComponent {

    private val userRepository: UserRepository by inject()

    override fun onViewCreate() {

    }

    override fun onGetUser() {
        userRepository.getAllUser()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    view.displayUser(it)
                }, {
                    view.displayError(it.message)
                })
    }

    override fun onSaveUser(users: List<UserEntity>) {
        userRepository.saveAllUser(users)
    }

    override fun onViewDestroy() {

    }
}
