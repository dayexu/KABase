package org.xc.kabase.module.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import org.xc.kabase.R
import org.xc.kabase.module.login.bean.User

/**
 * 欢迎页
 * Created by Administrator on 2018/11/8.
 */
class WelcomeActivity: AppCompatActivity() {

    lateinit var welcomeViewModel:WelcomeViewModel

    lateinit var liveDataStrTV: TextView
    lateinit var liveDataBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity_welcome)
        liveDataStrTV = findViewById(R.id.live_data_str)
        liveDataBtn = findViewById(R.id.live_data)

        welcomeViewModel = ViewModelProviders.of(this).get(WelcomeViewModel::class.java)
        welcomeViewModel.userData.observe(this, Observer<User?> {
            t: User? ->  liveDataStrTV.setText("${t!!.name}\n${t!!.age}\n${t!!.sex}\n${t!!.hobby}")
        })

        liveDataBtn.setOnClickListener {
            val intent = Intent(this,MActivity::class.java)
            startActivity(intent)

            Thread(Runnable {
                Thread.sleep(3000)
                runOnUiThread {
                    welcomeViewModel.userData.value = User("徐淳",26,"男","写代码打篮球")
                }
            }).start()
        }


    }
}