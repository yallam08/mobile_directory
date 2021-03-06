package com.yallam.apps.mobiledirectory.di

import com.yallam.apps.mobiledirectory.vvm.MainActivity
import com.yallam.apps.mobiledirectory.vvm.mobileslist.MobilesListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Yahia Allam on 10/05/2018
 */
@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeMobilesListFragment(): MobilesListFragment

}