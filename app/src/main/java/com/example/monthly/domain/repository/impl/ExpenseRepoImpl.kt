package com.example.monthly.domain.repository.impl

import com.example.monthly.domain.db.dao.ExpenseDao
import com.example.monthly.domain.models.ExpenseModel
import com.example.monthly.domain.repository.ExpenseRepository
import com.example.monthly.utils.Injector
import kotlinx.coroutines.flow.Flow

class ExpenseRepoImpl(
    private val dao: ExpenseDao = Injector.getInjector().getExpenseDao()
) : ExpenseRepository {

    override fun getAllExpenses(): Flow<List<ExpenseModel>> {
        return dao.getAllExpenses()
    }

    override suspend fun addNewExpense(expenseModel: ExpenseModel) {
        dao.insertNewExpense(expenseModel)
    }

    override suspend fun deleteExpense(expenseModel: ExpenseModel) {
        dao.deleteExpense(expenseModel)
    }

    override suspend fun updateExpenseDetails(expenseModel: ExpenseModel) {
        dao.insertNewExpense(expenseModel)
    }
}