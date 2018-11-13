package org.xc.kabase.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

/**
 * Created by Administrator on 2018/11/12.
 */
@Entity
class User {

    constructor(name: String?, age: Int?, sex: String?, hobby: String?) {
        this.name = name
        this.age = age
        this.sex = sex
        this.hobby = hobby
    }

    @PrimaryKey
    @NonNull
    var id:String? = null

    @ColumnInfo(name = "name")
    var name:String? = null

    @ColumnInfo(name = "age")
    var age:Int? = null

    @ColumnInfo(name = "sex")
    var sex:String? = null

    @ColumnInfo(name = "hobby")
    var hobby:String? = null
}