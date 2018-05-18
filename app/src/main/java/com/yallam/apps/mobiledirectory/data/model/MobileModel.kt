package com.yallam.apps.mobiledirectory.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json
import java.io.Serializable

/**
 * Created by Yahia Allam on 11/05/2018
 */
@Entity(tableName = "mobile")
data class MobileModel(
        @PrimaryKey(autoGenerate = true)
        val id: Int,

        @Json(name = "DeviceName")
        val deviceName: String?,

        @Json(name = "Brand")
        val brand: String?,

        @Json(name = "announced")
        val announced: String?,

        @Json(name = "os")
        val os: String?,

        @Json(name = "internal")
        val internalMemoryAndRam: String?,

        @Json(name = "primary_")
        val primaryCamera: String?,

        @Json(name = "secondary")
        val secondaryCamera: String?,

        @Json(name = "price")
        val price: String?
): Serializable