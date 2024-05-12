package dev.jakapw.alephnews.compose.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.jakapw.alephnews.data.model.HotTopics
import dev.jakapw.alephnews.ui.theme.AppTheme

@Composable
fun SearchNews(
    onButtonClick: (String) -> Unit,
    currentTopic: String,
    modifier: Modifier = Modifier
) {
    var searchVal by remember {
        mutableStateOf("")
    }
    val hotTopics = HotTopics.topics

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = searchVal,
            onValueChange = { searchVal = it },
            placeholder = { Text(text = "Search", style = AppTheme.typography.inputText) },
            shape = AppTheme.shape.textField,
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = AppTheme.colorScheme.surface,
                focusedContainerColor = AppTheme.colorScheme.surface,
                unfocusedBorderColor = Color.Unspecified,
                focusedBorderColor = Color.Unspecified,
                focusedTextColor = AppTheme.colorScheme.neutral,
                unfocusedPlaceholderColor = AppTheme.colorScheme.onSurface
            ),
            textStyle = AppTheme.typography.inputText,
            trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = AppTheme.size.paddingSmall)
        )
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState(0))
                .wrapContentSize(unbounded = true),
        ) {
            for (topic in hotTopics) {
                FilterButton(
                    text = topic,
                    onClick = {  onButtonClick(topic) },
                    isEnabled = if (currentTopic != topic) true else false
                )
            }
        }
    }
}

@Composable
fun FilterButton(
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = AppTheme.shape.button,
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colorScheme.primaryContainer,
            contentColor = AppTheme.colorScheme.onPrimaryContainer,
            disabledContainerColor = AppTheme.colorScheme.neutral,
            disabledContentColor = AppTheme.colorScheme.background
        ),
        modifier = Modifier.padding(AppTheme.size.paddingSmall)
    ) {
        Text(
            text = text,
            style = AppTheme.typography.labelMedium
        )
    }
}