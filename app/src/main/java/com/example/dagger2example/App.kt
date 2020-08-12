package com.example.dagger2example


import com.example.dagger2example.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        /*
         * ApplicationInject 메소드 만들때 Dagger 접두사가 붙는다는 것만 기억
         * interface 명을 AppComponent 라고 짓고 @Component Annotation 붙이면 노테이션 프로세서에 의해 자동으로 생성되는 명.
         * ex ) AppComponent -> DaggerAppComponent
         */
        return DaggerAppComponent.factory().create(this)
        // ApplicationInjector() 메소드를 구현하게 되는데 AppComponent 이용하여 안드로이드 인젝터 생성

    }
}