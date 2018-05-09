package com.yallam.apps.mobiledirectory

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import androidx.core.widget.toast
import com.yallam.apps.mobiledirectory.network.ApiEndpoints
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    //TODO: move to repository
    @Inject lateinit var apiEndpoints: ApiEndpoints

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO: move to repository
        apiEndpoints.getLatestPhones()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    toast("${it.size} phones retrieved", Toast.LENGTH_LONG)
                }, {
                    toast("Error! ${it.message}", Toast.LENGTH_LONG)
                })
    }

}
