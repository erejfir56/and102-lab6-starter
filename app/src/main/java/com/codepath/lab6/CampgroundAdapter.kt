package com.codepath.lab6

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.lab6.databinding.ItemCampgroundBinding

const val CAMPGROUND_EXTRA = "CAMPGROUND_EXTRA"

class CampgroundAdapter(
    private val context: Context,
    private val campgrounds: List<Campground>
) : RecyclerView.Adapter<CampgroundAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCampgroundBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(campgrounds[position])

    override fun getItemCount() = campgrounds.size

    inner class ViewHolder(private val binding: ItemCampgroundBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val campground = campgrounds[absoluteAdapterPosition]
                context.startActivity(
                    Intent(context, DetailActivity::class.java)
                        .putExtra(CAMPGROUND_EXTRA, campground)
                )
            }
        }

        fun bind(campground: Campground) {
            binding.itemCampgroundTitle.text = campground.name
            binding.itemCampgroundDescription.text = campground.description
            binding.itemCampgroundLatLong.text = campground.latLong
            Glide.with(context).load(campground.imageUrl).into(binding.itemCampgroundImage)
        }
    }
}
