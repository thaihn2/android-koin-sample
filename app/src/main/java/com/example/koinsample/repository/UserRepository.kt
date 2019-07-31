package com.example.koinsample.repository

import com.example.koinsample.data.local.LocalDatabase
import com.example.koinsample.data.local.entity.UserEntity
import io.reactivex.Observable
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

object UserRepository : KoinComponent {

    private val localDatabase: LocalDatabase by inject()

    fun saveAllUser(users: List<UserEntity>) {
        localDatabase.userDao().insertAllUser(users)
    }

    fun getAllUser(): Observable<List<UserEntity>> {
        return localDatabase.userDao().getAllUser()
    }
}
