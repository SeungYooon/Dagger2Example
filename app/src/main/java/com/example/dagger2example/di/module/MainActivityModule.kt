package com.example.dagger2example.di.module

import androidx.databinding.DataBindingUtil
import com.example.dagger2example.ui.MainActivity
import com.example.dagger2example.ui.MainFragment
import com.example.dagger2example.R
import com.example.dagger2example.databinding.ActivityMainBinding
import com.example.dagger2example.scope.FragmentScope
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

// 객체의 생성을 담당.
@Module
abstract class MainActivityModule {
    companion object {
        // 객체가 제공될것임을 명시적으로 알려준다.
        @Provides
        fun provideMainActivityBinding(activity: MainActivity): ActivityMainBinding {
            return DataBindingUtil.setContentView(activity,
                R.layout.activity_main
            )
        }
    }

    // 프래그먼트는 액티비티에 속하지만, 독립적인 생명주기를 가지므로 scope 따로 관리.
    @FragmentScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun getMainFragment(): MainFragment
}