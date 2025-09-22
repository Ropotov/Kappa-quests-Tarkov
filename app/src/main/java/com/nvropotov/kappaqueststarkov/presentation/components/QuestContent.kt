package com.nvropotov.kappaqueststarkov.presentation.components

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nvropotov.kappaqueststarkov.R
import com.nvropotov.kappaqueststarkov.domain.models.Filter
import com.nvropotov.kappaqueststarkov.domain.models.Quest
import com.nvropotov.kappaqueststarkov.presentation.MainViewModel
import com.nvropotov.kappaqueststarkov.presentation.theme.KappaQuestsTarkovTheme
import com.nvropotov.kappaqueststarkov.presentation.theme.primary
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

@SuppressLint("UnrememberedMutableState")
@Composable
fun QuestsContent(viewModel: MainViewModel, data: PersistentList<Quest>) {
    val scrollState = rememberLazyListState()
    val context = LocalContext.current
    var selected by remember { mutableStateOf(Filter.NOT_FILTER) }
    var showModal by remember { mutableStateOf(false) }
    var showSearch by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf(String()) }

    val localList = when (selected) {
        Filter.COMPLETED -> data.filter { it.isCompleted }
        Filter.NOT_COMPLETED -> data.filter { !it.isCompleted }
        Filter.NOT_FILTER -> data
    }.toPersistentList()


    val searchList = remember(data, searchText) {
        if (searchText.isNotEmpty()) {
            data.filter { (it.title).contains(searchText, ignoreCase = true) }
        } else {
            emptyList()
        }
    }

    val onSelect: (Filter) -> Unit = remember { { selected = it } }
    val onSearchClick = remember { { showSearch = !showSearch } }
    val openLink: (String) -> Unit =
        remember { { context.startActivity(Intent(Intent.ACTION_VIEW, it.toUri())) } }
    //TODO
    val select: (Quest) -> Unit = remember { { } }

    LaunchedEffect(localList) {
        if (localList.isEmpty() && selected != Filter.NOT_FILTER) {
            selected = Filter.NOT_FILTER
            showModal = true
        }
    }

    KappaQuestsTarkovTheme {
        Scaffold(
            topBar = {
                ToolBar(
                    selected,
                    onSelect,
                    onSearchClick,
                )
            },
            modifier = Modifier.background(Color.Transparent)
        ) { paddingValues ->
            if (showSearch) {
                CustomSearchBar(
                    searchText = searchText,
                    onSearchTextChange = { text -> searchText = text },
                    onClearSearch = { searchText = String() },
                    onSearchToggle = { showSearch = !showSearch },
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(primary.copy(alpha = 0.98f)),
                        contentPadding = PaddingValues(top = KappaQuestsTarkovTheme.dimens.dp18)
                    ) {
                        items(searchList) { quest ->
                            Quest(quest, openLink, select)
                        }
                    }
                }
            }
            if (showModal) {
                ModalDialog(
                    title = R.string.not_completed_title,
                    description = R.string.not_completed_description,
                    onDismiss = { showModal = false }
                )
            }
            LazyColumn(
                state = scrollState,
                modifier = Modifier
                    .background(primary)
                    .fillMaxSize(),
                contentPadding = paddingValues
            ) {
                items(localList) { quest ->
                    Quest(quest, openLink, select)
                }
            }
        }
    }
}