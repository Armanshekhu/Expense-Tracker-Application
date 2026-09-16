package com.example.expensetrackerapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensetrackerapplication.ui.theme.ExpenseTrackerApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreen() {
    var list = listOf("Food","Transport","Shopping","Education","Other")
    var id by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var amount by remember{mutableStateOf("")}
    val totalAmount by remember{ mutableIntStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Expense Tracker")

        Text("Total Expense : $totalAmount")

        OutlinedTextField(
            value = id,
            onValueChange = { id = it },
            label = { Text("ID")}
        )
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title")}
        )
        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount")}
        )
        OutlinedTextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Category")}
        )

        Button(
            onClick = {

            }
        ) {
            Text("Add Expense")
        }

        Text("No expense yet")
    }
}
