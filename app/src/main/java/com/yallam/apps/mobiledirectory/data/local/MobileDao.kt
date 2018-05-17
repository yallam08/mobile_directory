package com.yallam.apps.mobiledirectory.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.yallam.apps.mobiledirectory.data.model.MobileModel
import io.reactivex.Single

@Dao
interface MobileDao {
    @Query("SELECT * FROM mobile")
    fun getMobiles(): Single<List<MobileModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMobile(mobile: MobileModel)
}
