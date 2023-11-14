package com.example.alarmmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DestinationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination)

        val tvMessage = findViewById<TextView>(R.id.tv_message)
        tvMessage.text = intent.getStringExtra("message")
    }
}