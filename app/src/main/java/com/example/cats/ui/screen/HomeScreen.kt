package com.example.cats.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cats.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onCatClick: (catName: String, description: String) -> Unit
) {
    val cats by viewModel.cats.collectAsState()

    Scaffold { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(cats) { cat ->
                ListItem(
                    modifier = Modifier.clickable {
                        onCatClick("Gato ${cat.type}", cat.text ?: "Sem descrição")
                    },
                    overlineContent = { Text("Gato ${cat.type}") },
                    headlineContent = { Text(cat.text ?: "Sem Descrição") },
                )
            }
            item {
                OutlinedButton(
                    onClick = onBackClick
                ) {
                    Text("Voltar")
                }
            }
        }
    }
}