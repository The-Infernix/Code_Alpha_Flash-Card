package com.example.flashcard

import com.example.flashcard.AddFlashcardActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flashcard.databinding.ActivityMainBinding
import com.example.flashcard.RecallActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddFlashcardActivity::class.java))
        }

        binding.btnQuiz.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }

        binding.btnRecall.setOnClickListener {
            startActivity(Intent(this, RecallActivity::class.java)) // ✅ Fixed here
        }
    }
}
