package dev.jakapw.alephnews.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

data class AppColorScheme(
    val background: Color,
    val surface: Color,
    val primary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val neutral: Color,
    val semantic: Color,
    val onSurface: Color,
    )

data class AppTypography(
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,
    val body: TextStyle,
    val labelMedium: TextStyle,
    val labelSmall: TextStyle,
    val inputText: TextStyle
)

data class AppShape(
    val banner: Shape,
    val card: Shape,
    val textField: Shape,
    val button: Shape
)

data class AppSize (
    val paddingSmall: Dp,
    val paddingMedium: Dp,
    val paddingLarge: Dp
)

val LocalAppColorScheme = staticCompositionLocalOf {
    AppColorScheme(
        background = Color.Unspecified,
        surface = Color.Unspecified,
        primary = Color.Unspecified,
        primaryContainer = Color.Unspecified,
        onPrimaryContainer = Color.Unspecified,
        neutral = Color.Unspecified,
        semantic = Color.Unspecified,
        onSurface = Color.Unspecified
    )
}

val LocalAppTypography = staticCompositionLocalOf {
    AppTypography(
        titleLarge = TextStyle.Default,
        titleMedium = TextStyle.Default,
        titleSmall = TextStyle.Default,
        body = TextStyle.Default,
        labelMedium = TextStyle.Default,
        labelSmall = TextStyle.Default,
        inputText = TextStyle.Default
    )
}

val LocalAppShape = staticCompositionLocalOf {
    AppShape(
        banner = RectangleShape,
        card = RectangleShape,
        textField = RectangleShape,
        button = RectangleShape
    )
}

val LocalAppSize = staticCompositionLocalOf {
    AppSize(
        paddingSmall = Dp.Unspecified,
        paddingMedium = Dp.Unspecified,
        paddingLarge = Dp.Unspecified,
    )
}