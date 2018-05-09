package com.yallam.apps.mobiledirectory.di

import com.yallam.apps.mobiledirectory.base.MDApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Yahia Allam on 09/05/2018
 */
@Module
class AppModule(private val app: MDApplication) {

    @Singleton
    @Provides
    fun provideAppContext(): MDApplication = app

}