package com.example.dagger2example.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger2example.R
import com.example.dagger2example.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

// DaggerAppCompatActivity()를 상속하기 원치 않는 경우 onCreate 직접 AndroidInjection.inject(this@MainActivity) 호출.
class MainActivity : DaggerAppCompatActivity() {

    // MainActivityModule 에서 ActivityMainBinding 객체가 @Inject() 호출 시점에 binding 변수에 초기화 된다.
    @Inject
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                MainFragment()
            )
            .commitNow()
    }
}