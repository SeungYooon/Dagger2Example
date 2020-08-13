package com.example.dagger2example.di.component

import com.example.dagger2example.di.module.APIModule
import com.example.dagger2example.di.module.RetroModule
import com.example.dagger2example.factory.RetroViewModelFactory
import com.example.dagger2example.repository.RetrofitRepository
import com.example.dagger2example.ui.RetroFragment
import com.example.dagger2example.viewmodel.RetroViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [APIModule::class, RetroModule::class])
interface APIComponent {
    fun inject(retrofitRepository: RetrofitRepository)
    fun inject(retroViewModel: RetroViewModel)
    fun inject(retroViewModelFactory: RetroViewModelFactory)
    fun inject(retroFragment: RetroFragment)
}