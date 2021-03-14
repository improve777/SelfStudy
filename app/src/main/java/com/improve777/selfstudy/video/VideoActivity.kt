package com.improve777.selfstudy.video

import android.app.PictureInPictureParams
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Rational
import androidx.annotation.RequiresApi
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.improve777.common.base.BindActivity
import com.improve777.common.utils.click
import com.improve777.selfstudy.R
import com.improve777.selfstudy.databinding.ActivityVideoBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * [https://github.com/android/media-samples/blob/main/PictureInPictureKotlin/app/src/main/java/com/example/android/pictureinpicture/MainActivity.kt]
 */
@AndroidEntryPoint
class VideoActivity : BindActivity<ActivityVideoBinding>(R.layout.activity_video) {

    private var videoPlayer: ExoPlayer? = null
    private var sampleUrl = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"

    @RequiresApi(Build.VERSION_CODES.O)
    private val pictureInPictureParamsBuilder = PictureInPictureParams.Builder()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        videoPlayer = SimpleExoPlayer.Builder(this).build()
        binding.playerview.player = videoPlayer

        val dataSourceFactory = DefaultDataSourceFactory(this, "sample")
        val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse(sampleUrl))
        videoPlayer?.prepare(mediaSource)

        binding.btnPip click {
            minimize()
        }
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

    @RequiresApi(Build.VERSION_CODES.O)
    fun minimize() {
        pictureInPictureParamsBuilder.setAspectRatio(
            Rational(
                binding.playerview.width,
                binding.playerview.height,
            )
        )
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            enterPictureInPictureMode(pictureInPictureParamsBuilder.build())
        }
    }
}