package com.example.flashcard

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object FileHelper {
    private const val FILE_NAME = "flashcards.json"

    fun saveFlashcard(context: Context, flashcard: Flashcard) {
        val flashcards = loadFlashcards(context).toMutableList()
        flashcards.add(flashcard)
        val json = Gson().toJson(flashcards)
        context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE).use {
            it.write(json.toByteArray())
        }
    }

    fun loadFlashcards(context: Context): List<Flashcard> {
        return try {
            val json = context.openFileInput(FILE_NAME).bufferedReader().readText()
            val type = object : TypeToken<List<Flashcard>>() {}.type
            Gson().fromJson(json, type) ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun deleteAllFlashcards(context: Context) {
        context.deleteFile(FILE_NAME)
    }
}
