package com.felipevelez.bookproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.felipevelez.bookproject.databinding.ActivityMainBinding
import com.felipevelez.bookproject.databinding.ActivitySplashBinding
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding :ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        val timer = Timer()
        timer.schedule(timerTask {
            goToMainActivity()
        },2000
        ) 

        splashBinding.imageView.setOnClickListener { //metodo de views
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
           // finish() //destruye la actividad

        }

    }
}