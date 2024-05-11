package dev.jakapw.alephnews.compose.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.DefaultModelEqualityDelegate
import dev.jakapw.alephnews.ui.theme.AppTheme

@Composable
fun Banner(
    imgUrl: String = "",
    title: String = "",
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        AsyncImage(
            model = imgUrl,
            contentDescription = title,
            modelEqualityDelegate = DefaultModelEqualityDelegate,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
        )
        Box(modifier = Modifier
            .matchParentSize()
            .background(
                brush = Brush
                    .linearGradient(
                        colorStops = arrayOf(0.3f to Color(0x77000000), 1f to Color.Unspecified)
                    )
            )
        )
        Text(
            text = title,
            color = Color.White,
            style = AppTheme.typography.titleMedium,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(18.dp)
        )
    }
}