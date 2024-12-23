package com.souravpalitrana.androiduicomponents.servercommunication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository): ViewModel() {
    private var _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    fun getAllPosts() {
        viewModelScope.launch {
            try {
                val allPost = repository.getAllPosts()
                _posts.postValue(allPost)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return PostViewModel(PostRepository()) as T
            }
        }
    }

}