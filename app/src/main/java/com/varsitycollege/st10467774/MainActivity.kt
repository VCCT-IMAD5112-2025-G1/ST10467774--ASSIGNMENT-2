package com.varsitycollege.st10467774

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Find the start button and set a click listener
        val startButton = findViewById<Button>(R.id.startButton)
        // When clicked, move to the Quiz screen
        startButton.setOnClickListener {
            val intent = Intent(this, QuizActivity2::class.java)
            startActivity(intent)
            finish()
            // Closes the Welcome screen
            // }
        }

    }
}
