package com.codepath.lab6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.codepath.lab6.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val park = intent.getSerializableExtra(PARK_EXTRA) as? Park
        val campground = intent.getSerializableExtra(CAMPGROUND_EXTRA) as? Campground

        when {
            park != null -> populate(park.fullName, park.description, park.imageUrl)
            campground != null -> populate(campground.name, campground.description, campground.imageUrl)
        }
    }

    private fun populate(title: String?, description: String?, imageUrl: String?) {
        binding.detailTitle.text = title
        binding.detailDescription.text = description
        Glide.with(this).load(imageUrl).into(binding.detailImage)
    }
}
