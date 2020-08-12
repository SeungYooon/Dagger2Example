package com.example.dagger2example.di.module

import com.example.dagger2example.scope.Named
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {
    @Provides
    @Named("dagger")
    fun provideHelloWorld() = "Dagger2 Example"
}