package com.robustdev.samplecomposeapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robustdev.samplecomposeapp.model.Post
import com.robustdev.samplecomposeapp.datasource.remote.PostRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class PostUiState {
    data object Loading : PostUiState()
    data class Success(val posts: List<Post>) : PostUiState()
    data class Error(val message: String) : PostUiState()
}

@HiltViewModel
class SampleViewModel @Inject constructor(
    private val repo: PostRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow<PostUiState>(PostUiState.Loading)
    val uiState: StateFlow<PostUiState> = _uiState.asStateFlow()

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        _uiState.value = PostUiState.Loading

        viewModelScope.launch {
            try {
                val result = repo.getPosts()
                _uiState.value = PostUiState.Success(result)
            } catch (e: Exception) {
                _uiState.value = PostUiState.Error(e.message ?: "Unknown error")
            }
        }
    }

}