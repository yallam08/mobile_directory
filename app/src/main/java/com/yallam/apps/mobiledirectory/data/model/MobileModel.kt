package com.yallam.apps.mobiledirectory.data.model

import android.arch.persistence.room.Entity
import com.squareup.moshi.Json
import java.io.Serializable

/**
 * Created by Yahia Allam on 11/05/2018
 */
@Entity(tableName = "mobile", primaryKeys = ["deviceName"])
data class MobileModel(
        @field:Json(name = "DeviceName")
        val deviceName: String,

        @field:Json(name = "Brand")
        val brand: String?,

        @field:Json(name = "announced")
        val announced: String?,

        @field:Json(name = "os")
        val os: String?,

        @field:Json(name = "internal")
        val internalMemoryAndRam: String?,

        @field:Json(name = "primary_")
        val primaryCamera: String?,

        @field:Json(name = "secondary")
        val secondaryCamera: String?,

        @field:Json(name = "price")
        val price: String?
): Serializable