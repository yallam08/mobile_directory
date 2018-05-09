package com.yallam.apps.mobiledirectory.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Yahia Allam on 09/05/2018
 *
 * Add the mandatory token query param to all requests
 */
class ApiTokenInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalUrl = original.url()

        val url = originalUrl.newBuilder()
                .addQueryParameter(NetworkConstants.API_TOKEN_KEY, NetworkConstants.API_TOKEN)
                .build()

        val request = original.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}