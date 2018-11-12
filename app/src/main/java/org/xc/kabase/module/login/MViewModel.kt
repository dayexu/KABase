package org.xc.kabase.module.login

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import org.xc.kabase.module.login.bean.M

/**
 * Created by Administrator on 2018/11/12.
 */
class MViewModel(application: Application): AndroidViewModel(application) {

    val mData: MutableLiveData<M> = MutableLiveData()

}