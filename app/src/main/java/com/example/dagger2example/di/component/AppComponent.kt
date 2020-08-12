package com.example.dagger2example.di.component

import com.example.dagger2example.App
import com.example.dagger2example.di.module.ActivityModule
import com.example.dagger2example.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

// AndroidInjector 만들기 위한 인터페이스.
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityModule::class, AppModule::class])
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<App>

    /*
     * ..deprecated version..
     @Component.Builder
     abstract class Builder :  AndroidInjector.Builder<App>()
     * */
}