package com.example.dagger2example.di.module

import com.example.dagger2example.scope.ActivityScope
import com.example.dagger2example.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    // 액티비티 생명주기에 맞춰 객체를 관리 하기 위해 @ActivityScope annotation.
    @ActivityScope
    // 반환하는 객체가 생성되는 시점에 injection 제공할 모듈 명시.
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun getMainActivity(): MainActivity

    // 액티비티가 추가될 때마다 ActivityModule에 위와 같이 해당 액티비티를 반환하는 abstract 메소드 추가.
}
