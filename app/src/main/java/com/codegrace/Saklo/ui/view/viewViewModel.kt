package com.codegrace.Saklo.ui.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codegrace.Saklo.Graph
import com.codegrace.Saklo.data.room.Remedies
import com.codegrace.Saklo.ui.repository.Repository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class viewViewModel(
    private val repository: Repository = Graph.repository
):ViewModel() {
    var state by mutableStateOf(ViewState())
        private set

    init{
        getRemedies()
    }

    private fun getRemedies(){
        viewModelScope.launch {
            repository.remedies.collectLatest {
                state = state.copy(remedies = it)
            }
        }
    }
}

data class ViewState(val remedies: List<Remedies> = emptyList())