package com.m3u.features.main.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.m3u.data.database.entity.Feed
import com.m3u.features.main.R
import com.m3u.ui.components.SheetDialog
import com.m3u.ui.components.SheetItem
import com.m3u.ui.components.SheetTextField
import com.m3u.ui.model.LocalSpacing
import com.m3u.ui.model.LocalTheme

internal typealias OnUpdateStatus = (MainDialogStatus) -> Unit
internal typealias OnUnsubscribe = (feedUrl: String) -> Unit
internal typealias OnRename = (feedUrl: String, target: String) -> Unit

internal sealed class MainDialogStatus {
    object Idle : MainDialogStatus()
    data class Selections(
        val feed: Feed
    ) : MainDialogStatus()
}

@Composable
internal fun MainDialog(
    status: MainDialogStatus,
    update: OnUpdateStatus,
    unsubscribe: OnUnsubscribe,
    rename: OnRename,
    modifier: Modifier = Modifier
) {
    var editMode by remember { mutableStateOf(false) }
    val borderWidth by animateDpAsState(if (editMode) 6.dp else 2.dp)
    SheetDialog(
        visible = status is MainDialogStatus.Selections,
        onDismiss = {
            if (!editMode) {
                update(MainDialogStatus.Idle)
            }
        },
        border = BorderStroke(
            borderWidth,
            LocalTheme.current.divider.copy(alpha = 0.45f)
        ),
        verticalArrangement = Arrangement.spacedBy(LocalSpacing.current.small),
        modifier = modifier,
        content = {
            val theme = LocalTheme.current
            val currentStatus = remember { status as MainDialogStatus.Selections }
            if (status is MainDialogStatus.Selections) {
                var renamedText by remember {
                    mutableStateOf(currentStatus.feed.title)
                }
                SheetTextField(
                    text = renamedText,
                    onTextChange = { renamedText = it },
                    readOnly = !editMode,
                    icon = Icons.Rounded.Edit,
                    iconTint = if (editMode) theme.tint else theme.onBackground,
                    onIconClick = {
                        val target = !editMode
                        if (!target && renamedText != currentStatus.feed.title) {
                            rename(currentStatus.feed.url, renamedText)
                        }
                        editMode = target
                    }
                )
                if (!editMode) {
                    SheetItem(R.string.unsubscribe_feed) {
                        unsubscribe(currentStatus.feed.url)
                        update(MainDialogStatus.Idle)
                    }
                    val clipboardManager = LocalClipboardManager.current
                    SheetItem(R.string.copy_feed_url) {
                        val annotatedString = AnnotatedString(currentStatus.feed.url)
                        clipboardManager.setText(annotatedString)
                        update(MainDialogStatus.Idle)
                    }
                }
            }
        }
    )
}
