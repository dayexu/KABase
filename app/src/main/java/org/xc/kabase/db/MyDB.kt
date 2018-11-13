package org.xc.kabase.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import org.xc.kabase.db.dao.UserDao
import org.xc.kabase.db.entity.User

@Database(entities = [User::class],version = 1)
abstract class MyDB() : RoomDatabase() {

    abstract fun userDao(): UserDao
}