package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // getting rid of the status bar for the phone that was located at the top of the application.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        var firstName: TextInputEditText? = null
        var lastName: TextInputEditText? = null
        val strButton: Button = findViewById(R.id.strButton)
        firstName = findViewById(R.id.firstName)
        lastName = findViewById(R.id.lastName)
        // When clicking the start button the if statement will check if both the First Name and Last Name has been enter.
        // if ether the first name or the last name has not been entered a error message will be showed.
        strButton.setOnClickListener{
            if(firstName?.text.toString().isEmpty() || lastName?.text.toString().isEmpty()){
                Toast.makeText(this,
                    "Please enter in your first name and last name", Toast.LENGTH_SHORT).show()
                // if first name and last name is not empty then move to the next page for the application
            } else if(firstName?.text.toString().isNotEmpty() && lastName?.text.toString().isNotEmpty()){
                val fullName = "${firstName.text.toString()}" + " " + "${lastName.text.toString()}"
                val intent = Intent(this, QuizQuestionActivity:: class.java)
                intent.putExtra(Constants.UserName, fullName)
                startActivity(intent)
                finish()
            }
        }
    }
}