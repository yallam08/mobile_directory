package com.yallam.apps.mobiledirectory.di

import com.yallam.apps.mobiledirectory.base.MDApplication
import com.yallam.apps.mobiledirectory.vvm.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Yahia Allam on 09/05/2018
 */
@Singleton
@Component(
        modules = [AppModule::class, NetworkModule::class, BuildersModule::class]
)
interface AppComponent {
    fun inject(app: MDApplication)
    fun inject(mainActivity: MainActivity)
}