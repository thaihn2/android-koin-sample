package com.example.koinsample.data.local

import androidx.room.*
import com.example.koinsample.data.local.entity.UserEntity
import io.reactivex.Observable

@Dao
interface UserDao {

    @Query("SELECT * FROM users ORDER BY name")
    fun getAllUser(): Observable<List<UserEntity>>

    @Query("SELECT * FROM users WHERE name = :name")
    fun findUserByName(name: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userEntity: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUser(userEntity: List<UserEntity>)

    @Delete
    fun deleteUser(userEntity: UserEntity)
}
