package com.example.flashcard


import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flashcard.Flashcard
import com.example.flashcard.R
import com.google.gson.Gson
import java.io.File
import java.io.FileWriter

class AddFlashcardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_flashcard)

        val questionEdit = findViewById<EditText>(R.id.editQuestion)
        val answerEdit = findViewById<EditText>(R.id.editAnswer)
        val saveButton = findViewById<Button>(R.id.saveFlashcard)

        saveButton.setOnClickListener {
            val question = questionEdit.text.toString()
            val answer = answerEdit.text.toString()

            if (question.isNotEmpty() && answer.isNotEmpty()) {
                val flashcard = Flashcard(question, answer)
                saveFlashcardToFile(flashcard)
            } else {
                Toast.makeText(this, "Please enter both question and answer", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveFlashcardToFile(flashcard: Flashcard) {
        val dir = File(getExternalFilesDir(null), "Flashcards")
        if (!dir.exists()) dir.mkdirs()

        val file = File(dir, "${System.currentTimeMillis()}.json")
        val writer = FileWriter(file)
        val gson = Gson()

        writer.write(gson.toJson(flashcard))
        writer.close()

        Toast.makeText(this, "Flashcard saved!", Toast.LENGTH_SHORT).show()
    }
}
