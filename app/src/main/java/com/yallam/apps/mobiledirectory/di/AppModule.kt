package com.yallam.apps.mobiledirectory.di


import android.arch.persistence.room.Room
import com.yallam.apps.mobiledirectory.base.MDApplication
import com.yallam.apps.mobiledirectory.data.MobileRepository
import com.yallam.apps.mobiledirectory.data.local.Database
import com.yallam.apps.mobiledirectory.data.local.MobileDao
import com.yallam.apps.mobiledirectory.data.remote.ApiEndpoints
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

    @Singleton
    @Provides
    fun provideDatabase(app: MDApplication): Database =
            Room.databaseBuilder(app, Database::class.java, "mobiles_db")
                    .fallbackToDestructiveMigration()
                    .build()

    @Singleton
    @Provides
    fun provideMobileDao(database: Database): MobileDao = database.mobileDao()

    @Provides
    fun provideMobileRepository(apiEndpoints: ApiEndpoints, mobileDao: MobileDao): MobileRepository
            = MobileRepository(apiEndpoints, mobileDao)

}