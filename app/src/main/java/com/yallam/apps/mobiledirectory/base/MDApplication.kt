package com.yallam.apps.mobiledirectory.base

import android.app.Activity
import android.app.Application
import com.yallam.apps.mobiledirectory.di.AppModule
import com.yallam.apps.mobiledirectory.di.DaggerAppComponent
import com.yallam.apps.mobiledirectory.di.NetworkModule
import com.yallam.apps.mobiledirectory.network.NetworkConstants
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Yahia Allam on 09/05/2018
 */
class MDApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(NetworkConstants.API_BASE_URL))
                .build()
                .inject(this)
    }
}