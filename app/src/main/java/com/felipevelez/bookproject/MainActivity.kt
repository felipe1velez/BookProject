package com.felipevelez.bookproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameBookEditText : EditText = findViewById(R.id.name_book_edit_text)
        val saveButton : Button = findViewById(R.id.save_button)
        val infoTextView : TextView = findViewById(R.id.info_text_view)
        val nameAuthorEditText : EditText = findViewById(R.id.name_author_edit_text)

        saveButton.setOnClickListener {
            val nameBook : String = nameBookEditText.text.toString()
            infoTextView.text = nameBook
            val nameAuthor : String = nameAuthorEditText.text.toString()
            infoTextView.text = nameAuthor
        }
    }
}