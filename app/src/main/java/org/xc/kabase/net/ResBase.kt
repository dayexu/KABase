package org.xc.kabase.net

/**
 * 基础回参
 * Created by Administrator on 2018/11/7.
 */
class ResBase<T> {

    var code: Int? = null
    var msg: String? = null
    var data: T? = null
}