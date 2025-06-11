package com.example.flashcard

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.io.File

class QuizActivity : AppCompatActivity() {

    private var flashcards: List<Flashcard> = listOf()
    private var currentIndex = 0
    private lateinit var questionView: TextView
    private lateinit var answerView: TextView
    private lateinit var nextBtn: Button
    private lateinit var revealBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionView = findViewById(R.id.quizQuestion)
        answerView = findViewById(R.id.quizAnswer)
        nextBtn = findViewById(R.id.nextButton)
        revealBtn = findViewById(R.id.revealButton)

        loadFlashcards()
        showFlashcard()

        nextBtn.setOnClickListener {
            currentIndex = (currentIndex + 1) % flashcards.size
            showFlashcard()
        }

        revealBtn.setOnClickListener {
            answerView.text = flashcards[currentIndex].answer
        }
    }

    private fun loadFlashcards() {
        val dir = File(getExternalFilesDir(null), "Flashcards")
        val gson = Gson()
        val cards = mutableListOf<Flashcard>()

        dir.listFiles()?.forEach {
            val json = it.readText()
            cards.add(gson.fromJson(json, Flashcard::class.java))
        }

        flashcards = cards
    }

    private fun showFlashcard() {
        if (flashcards.isNotEmpty()) {
            questionView.text = flashcards[currentIndex].question
            answerView.text = "Tap reveal to see answer"
        } else {
            questionView.text = "No flashcards found"
            answerView.text = ""
        }
    }
}

