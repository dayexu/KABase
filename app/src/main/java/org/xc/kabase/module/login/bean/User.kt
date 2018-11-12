package org.xc.kabase.module.login.bean

/**
 * Created by Administrator on 2018/11/12.
 */
class User {

    constructor(name: String?, age: Int?, sex: String?, hobby: String?) {
        this.name = name
        this.age = age
        this.sex = sex
        this.hobby = hobby
    }

    var name:String? = null
    var age:Int? = null
    var sex:String? = null
    var hobby:String? = null
}