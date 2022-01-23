package com.com.torchkotlin

import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var cameraManager: CameraManager
    lateinit var cameaId: String
    var str = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
            if (!str) {
                cameaId = cameraManager.cameraIdList[0]
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    cameraManager.setTorchMode(cameaId,true)
                }
                str = true
                button.setText("Off")
            }else{
                cameaId = cameraManager.cameraIdList[0]
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    cameraManager.setTorchMode(cameaId,false)
                }
                button.setText("On")
                str =false
            }
        })
    }
}