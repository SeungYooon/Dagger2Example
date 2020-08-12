package com.example.dagger2example.di.module

import androidx.databinding.DataBindingUtil
import com.example.dagger2example.ui.MainActivity
import com.example.dagger2example.R
import com.example.dagger2example.databinding.FragmentMainBinding
import com.example.dagger2example.scope.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class MainFragmentModule {
    @Provides
    @FragmentScope
    fun provideMainFragmentBinding(activity: MainActivity): FragmentMainBinding {
        return DataBindingUtil.inflate(
            activity.layoutInflater,
            R.layout.fragment_main,
            null,
            false
        )
    }
}