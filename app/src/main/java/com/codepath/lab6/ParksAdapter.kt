package com.codepath.lab6

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.lab6.databinding.ItemParkBinding

const val PARK_EXTRA = "PARK_EXTRA"

class ParksAdapter(
    private val context: Context,
    private val parks: List<Park>
) : RecyclerView.Adapter<ParksAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemParkBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(parks[position])

    override fun getItemCount() = parks.size

    inner class ViewHolder(private val binding: ItemParkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val park = parks[absoluteAdapterPosition]
                context.startActivity(
                    Intent(context, DetailActivity::class.java)
                        .putExtra(PARK_EXTRA, park)
                )
            }
        }

        fun bind(park: Park) {
            binding.itemParkTitle.text = park.fullName
            binding.itemParkDescription.text = park.description
            Glide.with(context).load(park.imageUrl).into(binding.itemParkImage)
        }
    }
}
