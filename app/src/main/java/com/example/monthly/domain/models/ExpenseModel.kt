package com.example.monthly.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense_table")
data class ExpenseModel(
    val expenseTitle: String,
    val expenseDesc: String? = null,
    val timestamp: String? = null,
    val expenseCategory: Int? = null,
    val expenseFolderId: String? = null,    //card/wallet id
    val isTransfer: Boolean = false, //was it a transfer from card to cash
    val isExpense: Boolean = true   // true if spent, false if income
) {
    @PrimaryKey(autoGenerate = true)
    val expenseId: Long? = null
}