package com.app.quizzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.color.utilities.Score

class FinalScore : AppCompatActivity() {
    private var finalScore:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_score)
        finalScore=findViewById(R.id.finalScore)
        var Src : String? =intent.getStringExtra("final_score")
        Toast.makeText(this,"$Src",Toast.LENGTH_LONG).show()

        finalScore?.text= "Your Score:$Src/9"
    }
}