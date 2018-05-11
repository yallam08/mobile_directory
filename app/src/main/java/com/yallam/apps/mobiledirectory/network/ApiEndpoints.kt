package com.yallam.apps.mobiledirectory.network

import com.yallam.apps.mobiledirectory.data.model.MobileModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Yahia Allam on 09/05/2018
 */
interface ApiEndpoints {

    @GET("getlatest/")
    fun getLatestMobiles(@Query("brand") brand: String? = null): Observable<List<MobileModel>>

}