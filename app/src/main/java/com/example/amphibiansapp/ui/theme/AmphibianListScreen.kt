package com.example.amphibiansapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun AmphibianListScreen(viewModel: AmphibianViewModel = viewModel()) {
    val list = viewModel.amphibians.collectAsState().value
    LazyColumn {
        items(list) { amphibian ->
            AmphibianCard(amphibian = amphibian)
        }
    }
}
