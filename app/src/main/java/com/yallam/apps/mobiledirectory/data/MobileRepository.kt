package com.yallam.apps.mobiledirectory.data

import com.yallam.apps.mobiledirectory.data.local.MobileDao
import com.yallam.apps.mobiledirectory.data.model.MobileModel
import com.yallam.apps.mobiledirectory.data.remote.ApiEndpoints
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Yahia Allam on 11/05/2018
 */
class MobileRepository @Inject constructor(
        private val apiEndpoints: ApiEndpoints, private val mobileDao: MobileDao) {

    //TODO: insert to db first then retrieve
    fun getMobiles(): Observable<List<MobileModel>> {
        return getMobilesFromRemote()
    }

    private fun getMobilesFromRemote(): Observable<List<MobileModel>> {
        return apiEndpoints.getLatestMobiles()
                .doOnNext {
                    it.forEach {
                        mobileDao.insertMobile(it)
                    }
                }

    }

}