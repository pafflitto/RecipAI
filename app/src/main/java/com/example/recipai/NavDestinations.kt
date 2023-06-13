package com.example.recipai

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavDestinations(
    val navLabel: String,
    val displayLabel: Int,
    val icon: ImageVector,
    val iconSelected: ImageVector
) {
    Home(
        navLabel = "Home",
        displayLabel = R.string.home,
        icon = Icons.Rounded.Home,
        iconSelected = Icons.Filled.Home
    ),
    Favorites(
        navLabel = "Favorites",
        displayLabel = R.string.favorites,
        icon = Icons.Rounded.Favorite,
        iconSelected = Icons.Filled.Favorite
    ),
    Settings(
        navLabel = "Settings",
        displayLabel = R.string.settings,
        icon = Icons.Rounded.Settings,
        iconSelected = Icons.Filled.Settings
    )
}
