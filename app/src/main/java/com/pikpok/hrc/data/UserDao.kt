package com.pikpok.hrc.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.pikpok.hrc.data.dfd.EntityApps
import com.pikpok.hrc.data.dfd.EntityDataMob
import com.pikpok.hrc.data.grgr.EntityDepp
import com.pikpok.hrc.data.grgr.EntityEgypt
import io.reactivex.Flowable
import io.reactivex.Single


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)


    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Insert
    fun insertEgypt(egypt: EntityEgypt)

    @Query("SELECT * FROM EntityEgypt ORDER BY id DESC LIMIT 1")
    fun getEgypt(): Single<EntityEgypt>

    @Insert
    fun insertDeep(depp: EntityDepp)

    @Query("SELECT * FROM EntityDepp ORDER BY id DESC LIMIT 1")
    fun getDeep(): Single<EntityDepp>

    @Insert
    fun insertApss(apps: EntityApps)

    @Query("SELECT * FROM EntityApps ORDER BY id DESC LIMIT 1")
    fun getApps(): Flowable<List<EntityApps>>

    @Insert
    fun insertDataMob(dataMob: EntityDataMob)

    @Query("SELECT * FROM EntityDataMob ORDER BY id DESC LIMIT 1")
    fun getDataMob(): Single<EntityDataMob>

    @Insert
    fun insertGol(entityGol: EntityGol)

    @Query("SELECT * FROM EntityGol ORDER BY id DESC LIMIT 1")
    fun getGol(): Single<EntityGol>


}