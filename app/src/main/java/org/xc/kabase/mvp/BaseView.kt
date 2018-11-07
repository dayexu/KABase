package org.xc.kabase.mvp

/**
 * 基础View
 * Created by Administrator on 2018/11/7.
 */
interface BaseView {

    fun showLoading(msg: String,isCancel: Boolean)

    fun hideLoading()

    fun toast(msg: String)
}