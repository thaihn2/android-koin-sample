package com.example.koinsample.di

import androidx.room.Room
import com.example.koinsample.data.local.LocalDatabase
import com.example.koinsample.repository.UserRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val applicationModule = module(override = true) {
    single { UserRepository }
    single {
        Room.databaseBuilder(
                androidContext(),
                LocalDatabase::class.java,
                "demo-database"
        ).allowMainThreadQueries().build()
    }
}
