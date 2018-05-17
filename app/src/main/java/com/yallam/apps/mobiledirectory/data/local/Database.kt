package com.yallam.apps.mobiledirectory.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.yallam.apps.mobiledirectory.data.model.MobileModel

/**
 * Created by Yahia Allam on 17/05/2018
 */
@Database(entities = [MobileModel::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun mobileDao(): MobileDao
}