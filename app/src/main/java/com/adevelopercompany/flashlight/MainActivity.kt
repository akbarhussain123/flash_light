package com.adevelopercompany.flashlight

import android.content.Context
import android.graphics.Color
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    lateinit var cameraManager: CameraManager
    lateinit var tvTorch: TextView
    lateinit var ivTorch: ImageView
    var isFlash = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTorch = findViewById(R.id.tvTorch)
        ivTorch = findViewById(R.id.ivTorch)
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        ivTorch.setOnClickListener {
            toschOnorOf(it)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun toschOnorOf(view: View) {
        if (!isFlash) {
            val cameraListId = cameraManager.cameraIdList[0]
            cameraManager.setTorchMode(cameraListId, true)
            ivTorch.setImageResource(R.drawable.ic_torch_on)
            tvTorch.text = "Torch is on"
            tvTorch.setTextColor(Color.parseColor("#ffffff"))
            isFlash = true

        } else {

            val cameraListId = cameraManager.cameraIdList[0]
            cameraManager.setTorchMode(cameraListId, false)
            ivTorch.setImageResource(R.drawable.ic_torch_off)
            tvTorch.text = "Torch is off"
            tvTorch.setTextColor(Color.parseColor("#000000"))
            isFlash = false
        }


    }


}