package com.example.expensetrackerapplication.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.expensetrackerapplication.model.Expense
import com.example.expensetrackerapplication.model.ExpenseUiState
import com.example.expensetrackerapplication.repository.ExpenseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ExpenseViewModel : ViewModel() {

    private val repository  = ExpenseRepository()

//  remember is remove here bcz it stores state inside composition
//    var id = mutableStateOf("")
//        private set


//    StateFlow
    private val _uiState = MutableStateFlow(ExpenseUiState())


    val uiState : StateFlow<ExpenseUiState> = _uiState

    fun updateId(value : String) {
        _uiState.value  = _uiState.value.copy(
            id = value
        )
    }

    fun updateTitle(value : String) {
        _uiState.value = _uiState.value.copy(
            title = value
        )
    }

    fun updateCategory(value : String) {
        _uiState.value = _uiState.value.copy(
            category = value
        )
    }

    fun updateAmount(value : String) {
        _uiState.value = _uiState.value.copy(
            amount = value
        )
    }

    fun addExpense() {

        if(
            _uiState.value.id.isBlank() ||
            _uiState.value.title.isBlank() ||
            _uiState.value.category.isBlank()
        ) {
            return
        }

        val amountValue = _uiState.value.amount.toIntOrNull() ?: return

        val expense = Expense(
            id = _uiState.value.id,
            title = _uiState.value.title,
            amount = amountValue.toString(),
            category = _uiState.value.category
        )

        repository.addExpense(expense)

        _uiState.value = _uiState.value.copy (
            expenses = repository.getExpense()
        )

        clearFields()
    }

    fun deleteExpense(expense: Expense) {

        repository.deleteExpense(expense)

        _uiState.value = _uiState.value.copy(
            expenses = repository.getExpense()
        )

    }

    private fun clearFields() {
        _uiState.value = uiState.value.copy(
            id = "",
            title= "",
            amount= "",
            category= ""
        )
    }



}