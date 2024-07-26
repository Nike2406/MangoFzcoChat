package com.locus2.mangofzcochat.core.utils.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoadingView() {
    Column(modifier = Modifier.fillMaxSize()) {
        ProgressLoadingIndicator(paddingValues = PaddingValues())
    }
}