package com.example.quizapplication

data class Questions (
    // keep track on what question the application is currently on
    val id: Int,
    // Question
    val question: String,
    // Image
    val image: Int,
    // Options
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    // Correct Answer
    val correctAns: Int
)
