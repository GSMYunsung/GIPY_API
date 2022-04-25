package com.pss.gify_study.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.cys.gify_study.R
import com.cys.gify_study.databinding.ItemTrendGiphyBinding
import com.pss.gify_study.data.remote.model.Data
import com.pss.gify_study.widget.utils.DataDiffUtil

class GiphyAdapter(diffCallback: DiffUtil.ItemCallback<Data>) : PagingDataAdapter<Data,PagerViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder = PagerViewHolder.from(parent)

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}


class PagerViewHolder(private val binding: ItemTrendGiphyBinding) : RecyclerView.ViewHolder(binding.root)
{
    companion object {
        fun from(parent: ViewGroup): PagerViewHolder =
            PagerViewHolder(ItemTrendGiphyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    fun bind(data : Data?) : Unit = with(binding){
        if(data == null){
            Toast.makeText(root.context, "값이 불러와지지 못했습니다.", Toast.LENGTH_SHORT).show()
        }
        else{
            Glide.with(this.root).load(data.images.fixedWidth.url).transition(
                DrawableTransitionOptions.withCrossFade())
                .placeholder(
                    CircularProgressDrawable(binding.root.context).apply {
                    strokeWidth = 5f
                    centerRadius = 30f
                    start()
                })
                .into(imageView)
                .clearOnDetach()
        }
    }

}