package com.dvlpr.submission1_maghelheansgultom.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dvlpr.submission1_maghelheansgultom.R
import com.dvlpr.submission1_maghelheansgultom.ui.main.MainActivity

class SplashscreenActivity : AppCompatActivity() {
    private lateinit var handler: Handler
    private val delay: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        handler = Handler(mainLooper)
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, delay)
    }
}