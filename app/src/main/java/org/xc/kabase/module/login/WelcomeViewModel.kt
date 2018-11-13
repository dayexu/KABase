package org.xc.kabase.module.login

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import org.xc.kabase.db.entity.User

/**
 * Created by Administrator on 2018/11/12.
 */
class WelcomeViewModel(application: Application): AndroidViewModel(application) {

    var userData: MutableLiveData<User> = MutableLiveData()

}