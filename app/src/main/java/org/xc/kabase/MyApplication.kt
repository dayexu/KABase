package org.xc.kabase

import android.app.Application
import android.content.Context
import com.pgyersdk.crash.PgyCrashManager

/**
 * Created by Administrator on 2018/11/7.
 */
class MyApplication: Application() {

    lateinit var CONTEXT:Context

    override fun onCreate() {
        super.onCreate()
        CONTEXT = this

        //蒲公英初始化
        PgyCrashManager.register()
    }
}