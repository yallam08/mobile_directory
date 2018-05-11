package com.yallam.apps.mobiledirectory.data.model

import com.squareup.moshi.Json

/**
 * Created by Yahia Allam on 11/05/2018
 */
data class MobileModel(
        @Json(name = "DeviceName")
        val deviceName: String,

        @Json(name = "Brand")
        val brand: String,

        @Json(name = "announced")
        val announced: String,

        @Json(name = "os")
        val os: String,

        @Json(name = "internal")
        val internalMemoryAndRam: String,

        @Json(name = "primary_")
        val primaryCamera: String,

        @Json(name = "secondary")
        val secondaryCamera: String,

        @Json(name = "price")
        val price: String
) {
}