package org.xc.kabase.net

import android.content.Context
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 * 接口通用回调
 * Created by Administrator on 2018/11/7.
 */
abstract class ResCallback<T>:Observer<ResBase<T>> {

    private var mContext:Context

    constructor(context:Context) {
        this.mContext = context
    }


    override fun onNext(value: ResBase<T>) {
        if (value == null) {
            finish("抱歉，服务器正在维护",null)
            return
        }
        when (value.code) {
            0 -> {
                finish(value.msg,value.data)
            }
            else -> {

            }
        }
    }

    override fun onComplete() {
    }

    override fun onError(e: Throwable?) {
        if (e == null) {
            finish("抱歉，服务器正在维护",null)
            return
        }
        finish(e.message,null)
    }

    override fun onSubscribe(d: Disposable?) {
    }

    protected abstract fun finish(msg: String?, t: T?)
}