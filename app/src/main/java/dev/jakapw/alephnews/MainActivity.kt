package dev.jakapw.alephnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dev.jakapw.alephnews.compose.home.HomeScreen
import dev.jakapw.alephnews.data.viewmodel.HomeViewModel
import dev.jakapw.alephnews.ui.theme.AppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val homeViewModel: HomeViewModel = HomeViewModel.instance
        homeViewModel.updateTopHeadlines()

        setContent {
            AppTheme {
                HomeScreen(viewModel = homeViewModel, modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars))
            }
        }
    }
}