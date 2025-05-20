package com.varsitycollege.st10467774

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

@Suppress("unused", "UnusedVariable", "SameParameterValue")
class QuizActivity2 : AppCompatActivity() {
    // Array of questions
    val questions = arrayOf(
        "Nelson Mandela was the president in 1994.",
        "The Great Wall of China is visible from space.",
        "World War 1 ended in 1918.",
        "The pyramids were built in the 20th century.",
        "The first man on the moon was Neil Armstrong.",
        "The Berlin Wall fell in 1989.",
        "The Titanic sank on its first voyage."
    )

    // Array of corresponding answers (true or false)
    private val answers = arrayOf(true, false, true, false, true, true, true)

    // Keep track of the specific question the user is on
    private var currentQuestionText = 0

    // Keep score of the correct answers
    private var score = 0

    // Declare UI elements
    private lateinit var questionText: Text
    private lateinit var feedbackText: Text
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz2)

        // Link UI components to layout IDs
        findViewById<TextView>(R.id.questionTextView)
        findViewById<TextView>(R.id.feedbackTextView)
        trueButton = findViewById<Button>(R.id.trueButton)
        falseButton = findViewById<Button>(R.id.falseButton)
        nextButton = findViewById<Button>(R.id.nextButton)

        // Show the first question
        showQuestion()

        // Handle "True" button
        trueButton.setOnClickListener { check(true) }
        // Handle "False" button
        falseButton.setOnClickListener { check(false) }
        // Handle "Next" button
        nextButton.setOnClickListener {
            currentQuestionText++
            if (currentQuestionText < questions.size) {
                showQuestion()


            } else {
                // All questions answered
                val intent = Intent(this, ScoreActivity3::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }

        }
    }




    // Display the current question
private fun showQuestion() {
    val currentQuestionIndex = 0
    val questionTextView = question (currentQuestionIndex)
    nextButton.visibility = View.GONE
    trueButton.isEnabled = true
    falseButton.isEnabled = true
}
    private fun question(i: Int) {}

    // Check if the user's answer is correct
    private fun checkAnswer(userAnswer: Boolean) {
        val currentQuestionIndex = 0
        val correctAnswer = answers[currentQuestionIndex]
        val feedback = if (userAnswer == correctAnswer) {
            score++
            // Add to score if correct
            "Correct!"
        } else {
            "Incorrect!"
        }
        // Show result as a popup message
        Toast.makeText(this, feedback, Toast.LENGTH_SHORT).show()

        // Disable buttons and show "Next"
        trueButton.isEnabled = false
        falseButton.isEnabled = false
        nextButton.visibility = View.VISIBLE
    }
    }

