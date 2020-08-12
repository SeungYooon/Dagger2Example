package com.example.dagger2example.scope

import javax.inject.Scope

// 해당 프래그먼트에서만 객체를 관리.
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope