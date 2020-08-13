package com.example.dagger2example.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.dagger2example.R
import com.example.dagger2example.databinding.PostListLayoutBinding
import com.example.dagger2example.factory.RetroViewModelFactory
import com.example.dagger2example.model.PostInfo
import com.example.dagger2example.viewmodel.RetroViewModel

class RetroFragment : Fragment() {

    private lateinit var retroViewModel: RetroViewModel
    private var fragmentView: View? = null
    private var listAdapter: PostListAdapter? = null
    private lateinit var binding: PostListLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.post_list_layout, container, false)
        fragmentView = binding.root
        initAdapter()
        setAdapter()
        fetchRetroInfo()
        return fragmentView
    }

    private fun initAdapter() {
        listAdapter = PostListAdapter()
    }

    private fun setAdapter() {
        binding.postList.apply {
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            adapter = listAdapter
        }
    }

    private fun fetchRetroInfo() {
        retroViewModel.postInfoLiveData.observe(viewLifecycleOwner,
            Observer<List<PostInfo>> { t ->
                t?.apply {
                    listAdapter?.setAdapterList(t)
                }
            })
    }

    private fun initViewModel() {
        val retroViewMoFactory = RetroViewModelFactory()
        retroViewModel = ViewModelProvider(this, retroViewMoFactory).get(RetroViewModel::class.java)

    }

}