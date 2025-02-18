package com.example.charo_android.presentation.ui.home.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.charo_android.databinding.ItemHomeTodayDriveBinding
import com.example.charo_android.domain.model.home.TodayCharoDrive
import com.example.charo_android.presentation.ui.detail.DetailActivity
import com.example.charo_android.presentation.ui.home.HomeFragment

class HomeTodayDriveAdapter(
    val userId: String,
    var links: HomeFragment.DataToHomeLike
) : RecyclerView.Adapter<HomeTodayDriveAdapter.HomeTodayDriveViewHolder>() {
    private val _todayCharoDrive = mutableListOf<TodayCharoDrive>()
    private var todayCharoDrive: List<TodayCharoDrive> = _todayCharoDrive
    var postId: Int = 0
    var select = true

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeTodayDriveViewHolder {
        val binding = ItemHomeTodayDriveBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeTodayDriveViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: HomeTodayDriveViewHolder,
        position: Int
    ) {
        holder.onBind(todayCharoDrive[position])
        holder.binding.imgHomeTodayDriveHeart.setOnClickListener {
            if (select){
                it.isSelected = !todayCharoDrive[position].homeTodayDriveHeart

                select =false
            }else{
                it.isSelected = todayCharoDrive[position].homeTodayDriveHeart
                select = true
            }
            postId = todayCharoDrive[position].homeTodayDrivePostId

            links.getPostId(postId)

        }
        holder.binding.root.setOnClickListener() {
            val intent = Intent(holder.itemView?.context, DetailActivity::class.java)
            intent.putExtra("userId", userId)
            // intent.putExtra("postId", driveData[position].postId)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return todayCharoDrive.size
    }

    class HomeTodayDriveViewHolder(
        val binding: ItemHomeTodayDriveBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(todayCharoDrive: TodayCharoDrive) {
            binding.apply {
                binding.todayCharoDrive = todayCharoDrive
                binding.executePendingBindings()

            }
        }
    }

    fun setTodayDrive(todayCharoDrive: List<TodayCharoDrive>) {
        this.todayCharoDrive = todayCharoDrive
        notifyDataSetChanged()
    }
}