package com.pss.gify_study.widget.utils

import androidx.recyclerview.widget.DiffUtil
import com.pss.gify_study.data.remote.model.Data

class DataDiffUtil (
    private val oldList : List<Data>,
    private val newList : List<Data>
) : DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition] === newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =  oldList[oldItemPosition] == newList[newItemPosition]

}