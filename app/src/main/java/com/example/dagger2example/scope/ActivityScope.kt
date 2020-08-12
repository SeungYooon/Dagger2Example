package com.example.dagger2example.scope

import javax.inject.Scope

// 해당 액티비티에서만 객체를 관리.
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope