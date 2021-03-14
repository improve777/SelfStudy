package com.improve777.selfstudy.video

import android.net.Uri
import android.os.Bundle
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.improve777.common.base.BindActivity
import com.improve777.selfstudy.R
import com.improve777.selfstudy.databinding.ActivityVideoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoActivity : BindActivity<ActivityVideoBinding>(R.layout.activity_video) {

    private var videoPlayer: ExoPlayer? = null
    private var sampleUrl = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        videoPlayer = SimpleExoPlayer.Builder(this).build()
        binding.playerview.player = videoPlayer

        val dataSourceFactory = DefaultDataSourceFactory(this, "sample")
        val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse(sampleUrl))
        videoPlayer?.prepare(mediaSource)
    }

    override fun onResume() {
        super.onResume()
        videoPlayer?.playWhenReady = true
    }

    override fun onStop() {
        super.onStop()
        videoPlayer?.playWhenReady = false
        if (isFinishing) {
            videoPlayer?.release()
        }
    }
}