package com.app.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnstart: Button = findViewById(R.id.btn_start)
        val name:EditText = findViewById(R.id.text_name)
        btnstart.setOnClickListener{
            if(name.text.isNotEmpty()){
                val intent = Intent(this, QuizQuestionActivity::class.java)
                startActivity(intent)
                finish()
            } else{
                Toast.makeText(this,"Name cannot be empty ! ",Toast.LENGTH_LONG).show()
            }
        }
    }
}