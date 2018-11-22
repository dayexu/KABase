package org.xc.kabase.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.xc.kabase.R
import org.xc.library.util.LogUtil

class DemoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo_activity)

        findViewById<View>(R.id.save).setOnClickListener {
            rx_conacat()
        }
    }

    fun rx() {
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
            it.onNext(4)
            it.onNext(5)
            it.onNext(6)
            it.onComplete() //onComplete 后就不会再发射
            it.onNext(7)
        }).subscribe(object : Observer<Int> {

            private var i:Int = 0
            private var disposable: Disposable? = null

            override fun onSubscribe(d: Disposable?) {
                LogUtil.d("onSubscribe")
                disposable = d!!
            }

            override fun onComplete() {
                LogUtil.d("onComplete")
            }

            override fun onNext(value: Int?) {
                i = value!!
                if (i == 2) {
                    //中断发射
                    disposable!!.dispose()
                }
                LogUtil.d("onNext-> $value")
            }

            override fun onError(e: Throwable?) {
                LogUtil.d("onError-> ${e!!.message}")
            }
        })
    }

    fun rx_map() {
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
        }).map {
            when(it) {
                1 -> "100"
                2 -> "200"
                3 -> "300"
                else -> ""
            }
        }.subscribe {

        }
    }

    fun rx_conacat() {
        var observable1 = Observable.create(ObservableOnSubscribe<String> {
            it.onNext("observable1 - 1")
            it.onNext("observable1 - 2")
            it.onNext("observable1 - 3")

            //只有onComplete后下一个Observable
            it.onComplete()
        })

        var observable2 = Observable.create(ObservableOnSubscribe<String> {
            it.onNext("observable1 - 1")
            it.onNext("observable2 - 2")
            it.onNext("observable3 - 3")
        })

        Observable.concat(observable1,observable2)
                .subscribeOn(Schedulers.io())
                .subscribe {
                    LogUtil.d(it)
                }
    }
}