package org.xc.kabase.module.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import org.xc.kabase.module.login.bean.M

/**
 * Created by Administrator on 2018/11/12.
 */
class MActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mViewModel = ViewModelProviders.of(this).get(MViewModel::class.java)

        mViewModel.mData.observe(this, Observer {
            Log.d("MActivity","mData")
        })

        Thread(Runnable {
            Thread.sleep(2000)
            mViewModel.mData.postValue(M("cccc"))
        }).start()
    }
}