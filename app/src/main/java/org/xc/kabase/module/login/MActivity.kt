package org.xc.kabase.module.login

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Administrator on 2018/11/12.
 */
class MActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mViewModel = ViewModelProviders.of(this).get(MViewModel::class.java)

    }
}