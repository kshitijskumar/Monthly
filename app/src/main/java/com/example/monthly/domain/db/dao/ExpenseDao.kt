package com.example.monthly.domain.db.dao

import androidx.room.*
import com.example.monthly.domain.models.ExpenseModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Query("SELECT * FROM expense_table")
    fun getAllExpenses() : Flow<List<ExpenseModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewExpense(expense: ExpenseModel)

    @Delete
    suspend fun deleteExpense(expense: ExpenseModel)
}