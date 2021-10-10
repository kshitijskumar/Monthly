package com.example.monthly.domain.repository

import com.example.monthly.domain.models.ExpenseModel
import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {

    fun getAllExpenses() : Flow<List<ExpenseModel>>

    suspend fun addNewExpense(expenseModel: ExpenseModel)

    suspend fun deleteExpense(expenseModel: ExpenseModel)

    suspend fun updateExpenseDetails(expenseModel: ExpenseModel)

}