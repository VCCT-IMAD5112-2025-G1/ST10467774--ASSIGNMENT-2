package com.varsitycollege.st10467774

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

// ScoreActivity.kt - Displays final score and options to review or exit
class ScoreActivity3 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score3)

        // Get score from previous activity
        val score = intent.getIntExtra("score", 0)

        // Show feedback message
        val message = if (score >= 3) "Splendid job!" else "Keep practicing!"

        // Find UI elements
        val scoreText = findViewById<TextView>(R.id.scoreTextView)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        // Display score and message
        scoreText.text = "You got $score/7\n$message"

        // Handle Review button
        reviewButton.setOnClickListener {
            Toast.makeText(
                this, "Review features coming soon!",
                Toast.LENGTH_SHORT
            ).show()
        }
        // Exit app when Exit button is clicked
        exitButton.setOnClickListener {
            this.finishAffinity()
            // Closes the whole app
        }

    }
}