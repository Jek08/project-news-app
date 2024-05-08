package dev.jakapw.alephnews.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalContext
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val lightColorScheme = AppColorScheme(
    background = Color(0xFFFCFEFF),
    primary = Color(0xFF9FE5FF),
    primaryContainer = Color(0xFF9FE5FF),
    onPrimaryContainer = Color(0xFFFCFEFF),
    neutral = Color(0xFF333333),
    semantic = Color(0xFFFFD600)
)

private val darkColorTheme = AppColorScheme(
    background = Color(0xFF252525),
    primary = Color(0xFF9FE5FF),
    primaryContainer = Color(0xFF9FE5FF),
    onPrimaryContainer = Color(0xFFFCFEFF),
    neutral = Color(0xFFFCFEFF),
    semantic = Color(0xFFFFD600)
)

private val typography = AppTypography(
    titleLarge = TextStyle(
        fontFamily = RobotoSlab,
        fontSize = 20.sp
    ),
    titleMedium = TextStyle(
        fontFamily = RobotoSlab,
        fontSize = 16.sp
    ),
    titleSmall = TextStyle(
        fontFamily = RobotoSlab,
        fontSize = 12.sp
    ),
    body = TextStyle(
        fontFamily = RobotoSlab,
        fontSize = 11.sp
    ),
    labelMedium = TextStyle(
        fontFamily = RobotoSlab,
        fontSize = 13.sp
    ),
    labelSmall = TextStyle(
        fontFamily = RobotoSlab,
        fontSize = 9.sp
    )
)

private val shape = AppShape(
    banner = RoundedCornerShape(size = 10.dp),
    card = RoundedCornerShape(size = 10.dp),
    textField = RoundedCornerShape(50)
)

private val size = AppSize(
    paddingSmall = 8.dp,
    paddingMedium = 12.dp,
    paddingLarge = 15.dp
)

@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDarkTheme) darkColorTheme else lightColorScheme
    CompositionLocalProvider(
        LocalAppColorScheme provides colorScheme,
        LocalAppSize provides size,
        LocalAppTypography provides typography,
        LocalAppShape provides shape,
        content = content
    )
}

object AppTheme {
    val colorScheme: AppColorScheme
        @Composable get() = LocalAppColorScheme.current

    val typography: AppTypography
        @Composable get() = LocalAppTypography.current

    val shape: AppShape
        @Composable get() = LocalAppShape.current

    val size: AppSize
        @Composable get() = LocalAppSize.current
}