package com.example.koinsample.ui.main

import com.example.koinsample.data.local.entity.UserEntity

interface MainContract {

    interface View {
        fun displayUser(users: List<UserEntity>)
        fun displayError(message: String?)
    }

    interface Presenter {
        fun onViewCreate()
        fun onViewDestroy()
        fun onSaveUser(users: List<UserEntity>)
        fun onGetUser()
    }
}
