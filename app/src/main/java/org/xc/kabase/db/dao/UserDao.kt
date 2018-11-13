package org.xc.kabase.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import org.xc.kabase.db.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll():List<User>


    @Insert
    fun insert(user: User)
}