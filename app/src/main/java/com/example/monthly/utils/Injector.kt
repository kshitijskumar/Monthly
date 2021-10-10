package com.example.monthly.utils

import android.content.Context
import com.example.monthly.domain.db.dao.ExpenseDao
import com.example.monthly.domain.db.database.ExpenseDatabase
import kotlin.math.exp

class Injector private constructor() {

    private var expenseDb: ExpenseDatabase? = null
    private var expenseDao: ExpenseDao? = null

    fun setupExpenseDb(context: Context) {
        if (expenseDb != null) {
            expenseDb = ExpenseDatabase.getExpenseDatabase(context)
        }
    }

    fun getExpenseDao(): ExpenseDao {
        if (expenseDao == null) {
            expenseDao = expenseDb?.expenseDao ?: throw IllegalAccessException("ExpenseDb is not set up")
        }
        return expenseDao!!
    }

    companion object {
        private var instance: Injector? = null

        fun getInjector(): Injector {
            if (instance == null) {
                instance = Injector()
            }
            return instance!!
        }
    }
}