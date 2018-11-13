package org.xc.kabase.module.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.xc.kabase.R
import org.xc.kabase.databinding.LoginActivityWelcomeBinding

/**
 * 欢迎页
 * Created by Administrator on 2018/11/8.
 */
class WelcomeActivity: AppCompatActivity() {

    var mBing: LoginActivityWelcomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBing = DataBindingUtil.setContentView(this,R.layout.login_activity_welcome)


    }
}