package com.yallam.apps.mobiledirectory

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        Observable.timer(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .take(1)
                .subscribe({
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    this.finish()
                })
    }
}
