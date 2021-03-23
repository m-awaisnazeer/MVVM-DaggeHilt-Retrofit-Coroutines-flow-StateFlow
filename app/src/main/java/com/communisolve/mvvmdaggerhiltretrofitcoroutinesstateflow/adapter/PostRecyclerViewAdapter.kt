package com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.data.local.Post
import com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.databinding.EachRowBinding

class PostRecyclerViewAdapter(var postslist: List<Post>) :
    RecyclerView.Adapter<PostRecyclerViewAdapter.PostViewHolder>() {

    private lateinit var binding: EachRowBinding

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        binding =  EachRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PostViewHolder(
            binding.root
        )

      //  return PostViewHolder(EachRowBinding.inflate(LayoutInflater.from(parent.context),parent,false).root)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        binding.tasks.text = postslist.get(position).body
    }

    override fun getItemCount(): Int = postslist.size

    fun setData(postList:List<Post>){
        postslist = postList
        notifyDataSetChanged()
    }
}