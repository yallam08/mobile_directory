package com.yallam.apps.mobiledirectory.vvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import androidx.core.widget.toast
import com.yallam.apps.mobiledirectory.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var mainActivityViewModelFactory: MainActivityViewModelFactory
    @Inject lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this, mainActivityViewModelFactory)
                .get(MainActivityViewModel::class.java)

        mainActivityViewModel.mobilesLiveData.observe(this, Observer {
            toast("${it?.size} mobiles retrieved", Toast.LENGTH_LONG)
        })

        mainActivityViewModel.errorLiveData.observe(this, Observer {
            toast(it ?: "Some error happened!")
        })

    }

}
