package com.pikpok.hrc.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pikpok.hrc.data.dfd.EntityApps
import com.pikpok.hrc.data.dfd.EntityDataMob
import com.pikpok.hrc.data.grgr.EntityDepp
import com.pikpok.hrc.data.grgr.EntityEgypt

@Database(entities = [User::class, EntityEgypt::class, EntityDepp::class, EntityApps::class, EntityDataMob::class,EntityGol::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDataBase? = null

         fun getDataBase(context: Context): UserDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance=Room.databaseBuilder(
                    context.applicationContext,
                    UserDataBase::class.java,
                    "my_users_database_with_skins_buy"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }
}