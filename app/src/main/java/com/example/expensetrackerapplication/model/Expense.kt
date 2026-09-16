package com.example.expensetrackerapplication.model

data class Expense(
    val id : Int,
    val title : String,
    val amount : Double,
    val category: String
)
