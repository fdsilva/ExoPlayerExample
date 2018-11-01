package com.example.franciscoioneitondasilva.exoplayer

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.player_layout.*

class PlayerActivity: AppCompatActivity() {
    private val songURL = "http://www.largesound.com/ashborytour/sound/brobob.mp3"
    private lateinit var player: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.player_layout)

        buttonPlay

        settingPlayer()

        buttonPlay.setOnClickListener{
            player.playWhenReady = true
        }

        buttonPause.setOnClickListener{
            player.playWhenReady = false
        }

    }

    fun settingPlayer(){
        val dataSourceFactory = DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "exoplayer"))
        val mediaSource = ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(songURL))
        player = ExoPlayerFactory.newSimpleInstance(this)
        player.prepare(mediaSource)
    }

}