package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        //Username
        val USERName = intent.getStringExtra(Constants.UserName)
        var userName = findViewById<TextView>(R.id.userName)
        userName.text = USERName
        val TOTALquest = intent.getIntExtra(Constants.TotalQuestions, 0)
        val CORRECTans = intent.getIntExtra(Constants.CorrectAnswers, 0)
        var tv_Score = findViewById<TextView>(R.id.tv_Sorce)
        tv_Score.text = "Your score was $CORRECTans out fo $TOTALquest"
        val finishBT = findViewById<Button>(R.id.finishBT)
        finishBT.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
            finish()
        }

    }
}


