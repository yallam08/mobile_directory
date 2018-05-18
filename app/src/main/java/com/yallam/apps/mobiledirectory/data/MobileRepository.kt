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
        private val apiEndpoints: ApiEndpoints,
        private val mobileDao: MobileDao
) {

    /**
     * Retrieve from db after updating from remote. If not connected, get from db directly
     */
    fun getMobiles(): Observable<List<MobileModel>> {
        //TODO: add connectivity check
        return Observable.concatArrayEager(getMobilesFromRemote(), getMobilesFromDb())
    }

    private fun getMobilesFromRemote(): Observable<List<MobileModel>> {
        return apiEndpoints.getLatestMobiles()
                .doOnNext {
                    it.forEach {
                        mobileDao.insertMobile(it)
                    }
                }
    }

    private fun getMobilesFromDb(): Observable<List<MobileModel>> {
        return mobileDao.getMobiles().toObservable()
    }

}