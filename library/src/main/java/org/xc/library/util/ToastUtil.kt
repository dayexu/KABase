package org.xc.library.util

import android.content.Context
import android.widget.Toast

/**
 * Created by Administrator on 2018/11/7.
 */
class ToastUtil {

    companion object {

        private var toast: Toast? = null

        fun show(context: Context,msg: String) {
            if (toast == null) {
                toast = Toast.makeText(context,msg,Toast.LENGTH_SHORT)
            }
            toast!!.setText(msg)
            toast!!.show()
        }

        fun distory() {
            toast = null
        }
    }
}