package com.example.dagger2example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dagger2example.model.PostInfo
import com.example.dagger2example.repository.RetrofitRepository

class RetroViewModel(private var retrofitRepository: RetrofitRepository) : ViewModel() {

    var postInfoLiveData: LiveData<List<PostInfo>> = MutableLiveData()

    init {
        fetchPostInfoFromRepository()
    }

    private fun fetchPostInfoFromRepository() {
        postInfoLiveData = retrofitRepository.fetchPostInfoList()
    }
}