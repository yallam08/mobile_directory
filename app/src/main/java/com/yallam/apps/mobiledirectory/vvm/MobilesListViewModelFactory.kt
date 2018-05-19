package com.yallam.apps.mobiledirectory.vvm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * Created by Yahia Allam on 19/05/2018
 */
class MobilesListViewModelFactory
@Inject constructor(private val mobilesListViewModel: MobilesListViewModel): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MobilesListViewModel::class.java)) {
            return mobilesListViewModel as T
        } else {
            throw IllegalArgumentException("Unknown class!")
        }
    }
}