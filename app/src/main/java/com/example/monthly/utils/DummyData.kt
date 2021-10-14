package com.example.monthly.utils

import com.example.monthly.domain.models.CardDetails
import com.example.monthly.domain.models.ExpenseModel

object DummyData {

    val dummyCards = listOf<CardDetails>(
        CardDetails("2212 2120 2009", "Kshitij"),
        CardDetails("2212 2120 2009", "Kshitij"),
        CardDetails("2212 2120 2009", "Kshitij"),
    )

    val dummyExpenses = listOf<ExpenseModel>(
        ExpenseModel(expenseTitle = "Dribble Pro", timestamp = "22 Dec,2020", amount = 145),
        ExpenseModel(expenseTitle = "Figma", timestamp = "22 Dec,2020", amount = 200),
        ExpenseModel(expenseTitle = "Trell Stipend", timestamp = "4 Oct,2021", amount = 25000),
        ExpenseModel(expenseTitle = "Biryani", timestamp = "08 Oct,2021", amount = 350),
        ExpenseModel(expenseTitle = "Dribble Pro", timestamp = "22 Dec,2020", amount = 145),
        ExpenseModel(expenseTitle = "Figma", timestamp = "22 Dec,2020", amount = 200),
        ExpenseModel(expenseTitle = "Trell Stipend", timestamp = "4 Oct,2021", amount = 25000),
        ExpenseModel(expenseTitle = "Biryani", timestamp = "08 Oct,2021", amount = 350),
        ExpenseModel(expenseTitle = "Biryani", timestamp = "08 Oct,2021", amount = 350),
        ExpenseModel(expenseTitle = "Biryani", timestamp = "08 Oct,2021", amount = 350),
        ExpenseModel(expenseTitle = "Biryani", timestamp = "08 Oct,2021", amount = 350),
    )
}