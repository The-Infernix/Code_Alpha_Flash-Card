package com.example.flashcard

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.io.File

class RecallActivity : AppCompatActivity() {

    private lateinit var container: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recall)

        container = findViewById(R.id.recallContainer)
        loadFlashcards()
    }

    private fun loadFlashcards() {
        val dir = File(getExternalFilesDir(null), "Flashcards")
        val gson = Gson()

        if (dir.exists()) {
            dir.listFiles()?.forEach { file ->
                val flashcard = gson.fromJson(file.readText(), Flashcard::class.java)

                val cardView = TextView(this).apply {
                    text = "Q: ${flashcard.question}\nA: ${flashcard.answer}"
                    textSize = 18f
                    setPadding(16, 16, 16, 16)
                }

                val deleteBtn = Button(this).apply {
                    text = "Delete"
                    setOnClickListener {
                        file.delete()
                        container.removeView(cardView)
                        container.removeView(this)
                    }
                }

                container.addView(cardView)
                container.addView(deleteBtn)
            }
        }
    }
}
