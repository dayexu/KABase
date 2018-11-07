package org.xc.kabase.mvp

import android.content.Context

/**
 * 基础Presenter
 * Created by Administrator on 2018/11/7.
 */
class BasePresenter<T:BaseView> {

    protected lateinit var mContext:Context
    protected lateinit var mView:T

    constructor(context: Context, view: T) {
        this.mContext = context
        this.mView = view
    }
}