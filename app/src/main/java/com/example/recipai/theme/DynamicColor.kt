package com.example.recipai.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val ColorScheme.american: Color @Composable get() = if (isSystemInDarkTheme()) light_American else dark_American
val ColorScheme.americanText: Color @Composable get() = if (isSystemInDarkTheme()) light_onAmerican else dark_onAmerican
val ColorScheme.italian: Color @Composable get() = if (isSystemInDarkTheme()) light_Italian else dark_Italian
val ColorScheme.italianText: Color @Composable get() = if (isSystemInDarkTheme()) light_onItalian else dark_onItalian
val ColorScheme.mexican: Color @Composable get() = if (isSystemInDarkTheme()) light_Mexican else dark_Mexican
val ColorScheme.mexicanText: Color @Composable get() = if (isSystemInDarkTheme()) light_onMexican else dark_onMexican
val ColorScheme.mediterranean: Color @Composable get() = if (isSystemInDarkTheme()) light_Mediterranean else dark_Mediterranean
val ColorScheme.mediterraneanText: Color @Composable get() = if (isSystemInDarkTheme()) light_onMediterranean else dark_onMediterranean
val ColorScheme.chinese: Color @Composable get() = if (isSystemInDarkTheme()) light_Chinese else dark_Chinese
val ColorScheme.chineseText: Color @Composable get() = if (isSystemInDarkTheme()) light_onChinese else dark_onChinese
val ColorScheme.japanese: Color @Composable get() = if (isSystemInDarkTheme()) light_Japanese else dark_Japanese
val ColorScheme.japeneseText: Color @Composable get() = if (isSystemInDarkTheme()) light_onJapanese else dark_onJapanese
