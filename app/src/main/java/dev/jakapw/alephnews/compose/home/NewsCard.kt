package dev.jakapw.alephnews.compose.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.DefaultModelEqualityDelegate
import dev.jakapw.alephnews.R
import dev.jakapw.alephnews.ui.theme.AppTheme

@Composable
fun NewsCard(
    imgUrl: String,
    newsTitle: String,
    newsPublisher: String,
    newsDate: String,
    modifier: Modifier = Modifier
) {
    var isSaved by remember {
        mutableStateOf(false)
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .background(Color.White)
            .height(215.dp)
            .border(
                width = 1.dp,
                color = AppTheme.colorScheme.onSurface,
                shape = AppTheme.shape.card
            )
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .height(108.dp)
                .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
        ) {
            AsyncImage(
                model = imgUrl,
                contentDescription = "",
                modelEqualityDelegate = DefaultModelEqualityDelegate,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(maxWidth)
                    .height(maxHeight)
            )
            Box(modifier = Modifier
                .matchParentSize()
                .background(
                    brush = Brush
                        .linearGradient(
                            colorStops = arrayOf(0.3f to Color(0x44000000), 1f to Color.Unspecified)
                        )
                )
            )
            IconButton(
                onClick = { isSaved = true /*TODO: save news item*/ },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(7.dp)
                    .size(38.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.bookmark_icon),
                    contentDescription = "save news",
                    tint = Color.Unspecified)
            }
        }
        Text(
            text = newsTitle,
            style = AppTheme.typography.titleSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = AppTheme.size.paddingSmall)
        )
        Row(
            modifier = Modifier
                .padding(
                    start = AppTheme.size.paddingSmall,
                    end = AppTheme.size.paddingSmall,
                    bottom = AppTheme.size.paddingMedium
                )
        ) {
            Text(
                text = newsPublisher,
                style = AppTheme.typography.labelSmall,
                color = AppTheme.colorScheme.neutral
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Text(
                text = newsDate,
                style = AppTheme.typography.labelSmall,
                color = AppTheme.colorScheme.neutral)
        }
    }
}