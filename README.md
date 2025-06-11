# 📚 FlashCard Android App

FlashCard is a simple and lightweight Android app built using **Kotlin**. It allows users to create flashcards, quiz themselves, and quickly recall answers. Flashcards are stored **locally on the device** in a specific folder, with options to delete them when no longer needed.



## ✨ Features

- **Add Flashcards** – Save custom question-answer pairs
- **Quiz Mode** – Test your memory with random flashcards
- **Quick Recall** – Browse all saved flashcards with delete option
- **Local Storage** – Flashcards are saved in a folder within device storage



## 📂 Project Structure

```
FlashCard/
├── app/
│   ├── java/com.example.flashcard/
│   │   ├── MainActivity.kt
│   │   ├── AddFlashcardActivity.kt
│   │   ├── QuizActivity.kt
│   │   ├── RecallActivity.kt
│   │   └── Flashcard.kt
│   └── res/layout/
│       ├── activity_main.xml
│       ├── activity_add_flashcard.xml
│       ├── activity_quiz.xml
│       └── activity_recall.xml
├── AndroidManifest.xml
└── README.md
```



## ⚙️ How It Works

- Flashcards are saved as `.json` files in the `Flashcards` folder located at:  
  `Android/data/com.example.flashcard/files/Flashcards/`

- Each flashcard contains a question and its answer.

- You can delete a flashcard directly from the **Quick Recall** screen.



## 🚀 Getting Started

### Prerequisites

- Android Studio (latest stable)
- Kotlin support enabled

### Run Instructions

1. Clone this repository.
2. Open it in Android Studio.
3. Let Gradle sync automatically.
4. Run the app on an emulator or physical Android device.


## 📱 Screens Overview

- **Main Screen** – Choose between Add, Quiz, or Recall
- **Add Flashcard** – Enter a question and answer to save
- **Quiz Mode** – Answer questions randomly
- **Quick Recall** – View all flashcards and delete any as needed



## 🛡️ Permissions

These are already declared in the `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```



## 👨‍💻 Author

**Infernix**  
GitHub: [Infernix](https://github.com/The-Infernix)



