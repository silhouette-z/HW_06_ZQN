package me.zqn.hw_06_media


import android.graphics.PixelFormat
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

import java.io.IOException

class VideoActivity : AppCompatActivity() {
    var videoView:VideoView? =null
    var buttonPlay:Button? =null
    var buttonPause:Button? =null
//    var buttonReplay:Button? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        videoView = findViewById<VideoView>(R.id.videoView)
//        buttonPause = findViewById(R.id.buttonPause)
//        buttonPlay = findViewById(R.id.buttonPlay)
//        buttonReplay = findViewById(R.id.buttonPause)

        initLocalVideo();


//        buttonReplay!!.setOnClickListener { videoView!!.resume()}
//        buttonPause!!.setOnClickListener { videoView!!.pause() }
//        buttonPlay!!.setOnClickListener { videoView!!.start() }

//        videoView!!.holder.setFormat(PixelFormat.TRANSPARENT)
//        videoView!!.setZOrderOnTop(true)


    }

    private fun getVideoPath(resId: Int): String {
        return "android.resource://" + this.packageName + "/" + resId
    }
    private fun initLocalVideo(){
        val localMediaController = MediaController(this)
        videoView!!.setMediaController(localMediaController)
        videoView!!.setVideoPath(getVideoPath(R.raw.big_buck_bunny))
        videoView!!.start()
        videoView!!.holder.setFormat(PixelFormat.TRANSPARENT)
        videoView!!.setZOrderOnTop(true)
    }
}