package org.xc.kabase.module.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.xc.kabase.R

/**
 * 欢迎页
 * Created by Administrator on 2018/11/8.
 */
class WelcomeActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity_welcome)
    }
}