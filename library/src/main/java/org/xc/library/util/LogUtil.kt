package org.xc.library.util

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * 日志
 * Created by Administrator on 2018/11/7.
 */
class LogUtil {
    companion object {
        init {
            Logger.addLogAdapter(AndroidLogAdapter())
        }

        fun d(info: Any) {
            Logger.d(info)
        }
    }
}