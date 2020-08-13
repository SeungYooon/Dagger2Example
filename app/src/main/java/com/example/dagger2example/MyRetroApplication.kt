package com.example.dagger2example

import android.app.Application
import android.content.Context
import com.example.dagger2example.di.component.APIComponent
import com.example.dagger2example.di.component.DaggerAPIComponent
import com.example.dagger2example.di.module.APIModule

class MyRetroApplication : Application() {
    companion object {
        var context: Context? = null
        lateinit var apiComponent: APIComponent
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        apiComponent = initDaggerComponent()
    }

    fun getMyComponent(): APIComponent {
        return apiComponent
    }

    private fun initDaggerComponent(): APIComponent {
        apiComponent = DaggerAPIComponent
            .builder()
            .aPIModule(APIModule(BASE_URL))
            .build()
        return apiComponent
    }
}