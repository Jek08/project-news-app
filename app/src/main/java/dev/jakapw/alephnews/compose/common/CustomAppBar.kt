package dev.jakapw.alephnews.compose.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import dev.jakapw.alephnews.R
import dev.jakapw.alephnews.ui.theme.AppTheme
import dev.jakapw.alephnews.ui.theme.LocalAppSize

@Composable
fun CustomAppBar(
    modifier: Modifier = Modifier
) {
    val logoSmall = ImageVector.vectorResource(id = R.drawable.aleph_logo_small)
    Row(
        modifier.fillMaxWidth()
            .padding(
                vertical = LocalAppSize.current.paddingSmall
            )
    ) {
        Image(imageVector = logoSmall, contentDescription = "")
    }
}

@Preview
@Composable
fun TopBarPreview() {
    AppTheme {
        CustomAppBar()
    }
}