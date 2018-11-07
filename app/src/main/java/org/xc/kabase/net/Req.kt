package org.xc.kabase.net

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.xc.kabase.Const
import org.xc.library.util.LogUtil
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2018/11/7.
 */
class Req {

    companion object {
        private var retrofit: Retrofit?

        init {
            val okhttp:OkHttpClient = OkHttpClient.Builder()
                    .connectTimeout(10,TimeUnit.SECONDS)
                    .addInterceptor(LogInterceptor())
                    .build()

            retrofit = Retrofit.Builder()
                    .baseUrl(Const.API_BASE_URL)
                    .client(okhttp)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

        }

        fun <T> create(clazz: Class<T>): T {
            return retrofit!!.create(clazz)
        }
    }

    private class LogInterceptor:Interceptor {
        override fun intercept(chain: Interceptor.Chain?): Response {
            val t1 = System.currentTimeMillis()
            val request = chain!!.request()
            LogUtil.d(request.url())
            LogUtil.d(request.headers())
            LogUtil.d(request.body().toString())

            val response = chain!!.proceed(request)
            val t2 = System.currentTimeMillis()
            LogUtil.d(response.request().url())
            LogUtil.d(t2 - t1)
            LogUtil.d(response.headers())
            LogUtil.d(response.body().toString())

            return response
        }
    }
}