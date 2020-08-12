package com.example.dagger2example.scope

import javax.inject.Qualifier

// 타입은 같은데 다른 객체의 주입을 원하는 경우 @Qualifier Annotation 사용.
@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class Named(val value: String = "")