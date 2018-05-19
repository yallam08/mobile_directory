package com.yallam.apps.mobiledirectory.vvm

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.yallam.apps.mobiledirectory.data.MobileRepository
import com.yallam.apps.mobiledirectory.data.model.MobileModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Yahia Allam on 18/05/2018
 */
class MobilesListViewModel @Inject constructor(
        private val mobileRepository: MobileRepository
) : ViewModel() {
    val mobilesLiveData: MutableLiveData<List<MobileModel>> = MutableLiveData()
    val errorLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        mobileRepository
                .getMobiles()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    mobilesLiveData.postValue(it)
                }, {
                    errorLiveData.postValue("ERROR! ${it.message}")
                })
    }
}