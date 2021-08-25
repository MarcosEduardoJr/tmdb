package com.tmdb.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.tmdb.R
import com.tmdb.databinding.ActivityHomeBinding
import com.tmdb.presentation.artist.ArtistActivity
import com.tmdb.presentation.movie.MovieActivity
import com.tmdb.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.apply {
            movies.setOnClickListener {
                startActivity(Intent(this@HomeActivity, MovieActivity::class.java))
            }
            tvShows.setOnClickListener {
                startActivity(Intent(this@HomeActivity, TvShowActivity::class.java))
            }
            artists.setOnClickListener {
                startActivity(Intent(this@HomeActivity, ArtistActivity::class.java))
            }
        }


    }
}