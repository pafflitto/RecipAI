package com.example.recipai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.home.HomeScreen
import com.example.home.HomeViewModel
import com.example.home.bottomSheets.BottomSheetScreen
import com.example.recipai.theme.RecipAiTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<HomeViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val bottomSheetState = rememberStandardBottomSheetState(
                initialValue = SheetValue.Hidden,
                skipHiddenState = false
            )

            val scaffoldState = rememberBottomSheetScaffoldState(
                bottomSheetState = bottomSheetState
            )

            val uiController = rememberSystemUiController()
            val scope = rememberCoroutineScope()
            LaunchedEffect(bottomSheetState.targetValue) {
                uiController.isNavigationBarVisible = bottomSheetState.targetValue == SheetValue.Hidden
                uiController.setNavigationBarColor(Color.Transparent)
            }
            fun openBottomSheet() {
                scope.launch {
                    bottomSheetState.expand()
                }
            }

            fun closeBottomSheet() {
                scope.launch {
                    bottomSheetState.hide()
                }
            }
            RecipAiTheme {
                BottomSheetScaffold(
                    modifier = Modifier.systemBarsPadding(),
                    scaffoldState = scaffoldState,
                    sheetPeekHeight = 0.dp,
                    sheetContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    sheetTonalElevation = 0.dp,
                    sheetShadowElevation = 16.dp,
                    sheetContent = {
                        BottomSheetScreen(
                            viewModel = viewModel,
                            closeBottomSheet = {
                                closeBottomSheet()
                            }
                        )
                    }
                ) {
                    Surface {
                        HomeScreen(
                            viewModel = viewModel,
                            openBottomSheet = {
                                openBottomSheet()
                            },
                            closeBottomSheet = {
                                closeBottomSheet()
                            }
                        )
                    }
                }
            }
        }
    }
}
