package com.example.dagger2example.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger2example.BR
import com.example.dagger2example.MyRetroApplication.Companion.context
import com.example.dagger2example.R
import com.example.dagger2example.databinding.PostListItemBinding
import com.example.dagger2example.model.PostInfo

class PostListAdapter : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    private var list: List<PostInfo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: PostListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.post_list_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setAdapterList(list: List<PostInfo>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: PostListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(postinfo: PostInfo) {
            binding.apply {
                postmodel = postinfo
                executePendingBindings() // similar notifyDataSetChanged()
            }
        }
    }
}