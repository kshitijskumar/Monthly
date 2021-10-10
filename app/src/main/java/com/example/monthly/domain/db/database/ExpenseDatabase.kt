package com.example.monthly.domain.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.monthly.domain.db.dao.ExpenseDao
import com.example.monthly.domain.models.ExpenseModel

@Database(
    entities = [ExpenseModel::class],
    version = 1
)
abstract class ExpenseDatabase : RoomDatabase() {

    abstract val expenseDao: ExpenseDao

    companion object {

        @Volatile
        private var INSTANCE: ExpenseDatabase? = null

        fun getExpenseDatabase(context: Context) : ExpenseDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance != null) return instance
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExpenseDatabase::class.java,
                    "expenseDb"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return INSTANCE!!
            }
        }
    }
}