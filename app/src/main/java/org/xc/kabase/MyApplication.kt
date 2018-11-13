package org.xc.kabase

import android.app.Application
import android.arch.persistence.room.Room
import com.pgyersdk.crash.PgyCrashManager
import org.xc.kabase.db.MyDB

/**
 * Created by Administrator on 2018/11/7.
 */
class MyApplication: Application() {

    companion object {

        //数据库
        lateinit var DB:MyDB

    }

    override fun onCreate() {
        super.onCreate()

        DB = Room.databaseBuilder(this,MyDB::class.java,"db").build()

        //蒲公英初始化
        PgyCrashManager.register()


    }
}