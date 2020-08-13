package com.example.dagger2example.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dagger2example.MyRetroApplication
import com.example.dagger2example.di.component.APIComponent
import com.example.dagger2example.repository.RetrofitRepository
import com.example.dagger2example.viewmodel.RetroViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class RetroViewModelFactory : ViewModelProvider.Factory {
    @Inject
    lateinit var retrofitRepository: RetrofitRepository

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val apiComponent = MyRetroApplication.apiComponent
        apiComponent.inject(this)

        if (modelClass.isAssignableFrom(RetroViewModel::class.java)) {
            return RetroViewModel(retrofitRepository) as T
        }
        throw IllegalArgumentException("UnKnown ViewModel class")
    }
}