package com.example.dagger2example.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dagger2example.databinding.FragmentMainBinding
import com.example.dagger2example.scope.Named
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment @Inject constructor() : DaggerFragment() {

    @Inject
    lateinit var binding: FragmentMainBinding

    @Inject
    @Named("dagger")
    lateinit var txtDagger: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            txtView.text = txtDagger
        }
    }
}