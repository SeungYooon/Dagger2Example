package com.example.dagger2example.di.module

import com.example.dagger2example.MyRetroApplication
import dagger.Module
import dagger.Provides

@Module
class RetroModule constructor(private var myRetroApplication: MyRetroApplication) {
    @Provides
    fun provideMyRetroApplication(): MyRetroApplication {
        return myRetroApplication
    }
}