package com.yallam.apps.mobiledirectory.data

import com.yallam.apps.mobiledirectory.data.model.MobileModel
import com.yallam.apps.mobiledirectory.network.ApiEndpoints
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Yahia Allam on 11/05/2018
 */
class MobileRepository @Inject constructor(private val apiEndpoints: ApiEndpoints) {

    fun getMobiles(): Observable<List<MobileModel>> {
        return apiEndpoints.getLatestMobiles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    }

}