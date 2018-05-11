package com.yallam.apps.mobiledirectory

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import androidx.core.widget.toast
import com.yallam.apps.mobiledirectory.data.MobileRepository
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    //TODO: move to viewModel
    @Inject
    lateinit var mobileRepository: MobileRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO: move to viewModel
        mobileRepository.getMobiles()
                .subscribe({
                    toast("${it.size} mobiles retrieved", Toast.LENGTH_LONG)
                }, {
                    toast("Error! ${it.message}", Toast.LENGTH_LONG)
                })
    }

}
