package com.example.dagger2example.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.dagger2example.R
import com.example.dagger2example.databinding.NetworkLayoutBinding

class NetworkActivity : AppCompatActivity() {

    private lateinit var binding: NetworkLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.network_layout)
        replaceFragment()
    }

    private fun replaceFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_retro_room, RetroFragment())
            .commitNow()
    }
}