package com.example.charo_android.presentation.ui.search

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.charo_android.databinding.ItemResultSearchBinding
import com.example.charo_android.domain.model.more.MoreDrive
import com.example.charo_android.domain.model.search.SearchDrive
import com.example.charo_android.presentation.ui.detail.DetailActivity

class ResultSearchAdapter() :
    RecyclerView.Adapter<ResultSearchAdapter.ResultSearchViewHolder>() {
    private val _searchData = mutableListOf<SearchDrive>()
    private var searchData: List<SearchDrive> = _searchData

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResultSearchAdapter.ResultSearchViewHolder {
        val binding = ItemResultSearchBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ResultSearchViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ResultSearchAdapter.ResultSearchViewHolder,
        position: Int
    ) {
        holder.onBind(searchData[position])
        holder.binding.root.setOnClickListener() {
            val intent = Intent(holder.itemView?.context, DetailActivity::class.java)
            intent.putExtra("postId", searchData[position].postId)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return searchData.size
    }

    class ResultSearchViewHolder(
        val binding: ItemResultSearchBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(searchData: SearchDrive) {
            binding.apply{
                searchDrive = searchData
                binding.executePendingBindings()
            }

        }

    }

    fun setSearchDrive(searchDrive: List<SearchDrive>){
        this.searchData = searchDrive
        notifyDataSetChanged()
    }
}


