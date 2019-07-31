package com.example.koinsample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.koinsample.data.local.entity.UserEntity

@Database(
        entities = [
            UserEntity::class
        ],
        version = 1
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
