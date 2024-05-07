package com.example.marvelapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.marvelapp.model.ResultModel
import com.sample.myapplication.R
import com.sample.myapplication.databinding.MusicItemBinding

class MusicAdapter(
    val musicList: List<ResultModel>,
): RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    inner class MusicViewHolder(itemView: View): ViewHolder(itemView) {
        val binding = MusicItemBinding.bind(itemView)
        fun updateUI(resultItemModel: ResultModel) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(resultItemModel.artworkUrl60)
                    .placeholder(R.drawable.baseline_person_24)
                    .into(ivProfile)
                tvName.text = "Name: ${resultItemModel.artistName}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        return MusicViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.music_item, parent, false)
        )
    }

    override fun getItemCount() = musicList.size

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.updateUI(musicList[position])
    }

}