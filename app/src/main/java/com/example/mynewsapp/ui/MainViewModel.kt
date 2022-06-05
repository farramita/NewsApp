package com.example.mynewsapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewsapp.data.api.Article
import com.example.mynewsapp.repository.MainRepository
import com.example.mynewsapp.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository
)  : ViewModel() {

    init {
        fetch()
    }

    val articles = MutableLiveData<List<Article>?>()
    val msg = MutableLiveData<String>()

    private fun fetch() = viewModelScope.launch {
        val res = mainRepository.getNews()
        when(res){
            is Resource.Success -> {
                articles.postValue(res.data.articles)
            }
            is Resource.Failure -> {
                articles.postValue(null)
                msg.postValue(res.msg)
            }
        }
    }
}