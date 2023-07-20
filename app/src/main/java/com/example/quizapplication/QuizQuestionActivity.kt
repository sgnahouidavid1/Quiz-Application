package com.example.quizapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener{
    //(ansCorrectly) Number of question answer correctly
    private var ansCorrectly: Int = 0
    private var myCurrentPosition: Int = 1
    // selected option position
    private var mySelectedOptionPos: Int = 0
    // question list (know what question is show)
    private var myQuestionList: ArrayList<Questions>? = null

    // User name
    private var myUserName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        // setting up the user name
        myUserName = intent.getStringExtra(Constants.UserName)
        val tvOptionOne = findViewById<TextView>(R.id.tvOptionOne)
        val tvOptionTwo = findViewById<TextView>(R.id.tvOptionTwo)
        val tvOptionThree = findViewById<TextView>(R.id.tvOptionThree)
        val tvOptionFour = findViewById<TextView>(R.id.tvOptionFour)
        // shows how many question there are in the Quiz
        myQuestionList = Constants.getQuestions()

        setQuestion()
        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        val submitBt = findViewById<Button>(R.id.submitBt)
        submitBt.setOnClickListener(this)

    }
    private fun setQuestion(){
        val submitBt = findViewById<Button>(R.id.submitBt)
        val question = myQuestionList!![myCurrentPosition - 1]
        defaultOptionView()
        if (myCurrentPosition == myQuestionList!!.size){
            submitBt.text = "FINISH"
        }else {
            submitBt.text = "SUBMIT"
        }
        var progressBar = findViewById<ProgressBar>(R.id.progressBar)
        var tv_Progress = findViewById<TextView>(R.id.tv_Progress)
        progressBar.progress = myCurrentPosition
        tv_Progress.text = "$myCurrentPosition" + "/" + progressBar.max
        var tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        tvQuestion.text = question!!.question
        var ivImage = findViewById<ImageView>(R.id.ivImage)
        ivImage.setImageResource((question.image))
        var tvOptionOne = findViewById<TextView>(R.id.tvOptionOne)
        var tvOptionTwo = findViewById<TextView>(R.id.tvOptionTwo)
        var tvOptionThree = findViewById<TextView>(R.id.tvOptionThree)
        var tvOptionFour = findViewById<TextView>(R.id.tvOptionFour)
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour
    }
        private fun defaultOptionView(){
            val options = ArrayList<TextView>()
            var tvOptionOne = findViewById<TextView>(R.id.tvOptionOne)
            var tvOptionTwo = findViewById<TextView>(R.id.tvOptionTwo)
            var tvOptionThree = findViewById<TextView>(R.id.tvOptionThree)
            var tvOptionFour = findViewById<TextView>(R.id.tvOptionFour)
            options.add(0, tvOptionOne)
            options.add(1, tvOptionTwo)
            options.add(2, tvOptionThree)
            options.add(3,tvOptionFour)

            for(option in options){
                option.setTextColor(Color.parseColor("#14649F"))
                option.typeface = Typeface.DEFAULT
                option.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.default_option_border_bg
                )
            }
        }

    override fun onClick(v: View?) {
        var tvOptionOne = findViewById<TextView>(R.id.tvOptionOne)
        var tvOptionTwo = findViewById<TextView>(R.id.tvOptionTwo)
        var tvOptionThree = findViewById<TextView>(R.id.tvOptionThree)
        var tvOptionFour = findViewById<TextView>(R.id.tvOptionFour)
        val submitBt = findViewById<Button>(R.id.submitBt)
        when(v?.id) {
                R.id.tvOptionOne -> {
                    selectedOpView(tvOptionOne,1)
                }
                R.id.tvOptionTwo -> {
                    selectedOpView(tvOptionTwo,2)
                }
                R.id.tvOptionThree -> {
                    selectedOpView(tvOptionThree,3)
                }
                R.id.tvOptionFour -> {
                    selectedOpView(tvOptionFour,4)
                }
            R.id.submitBt ->{
                    // this is what will happen when the submit button is click
                    if(mySelectedOptionPos == 0){
                        // showing going to the next question
                        myCurrentPosition++
                        when {
                            myCurrentPosition <= myQuestionList!!.size -> {
                                setQuestion()
                            }else ->{
                                // when clicking the finish button the result page will be shown
                                val intent = Intent(this, ResultsActivity:: class.java)
                                intent.putExtra(Constants.UserName, myUserName)
                                intent.putExtra(Constants.TotalQuestions, myQuestionList!!.size)
                                intent.putExtra(Constants.CorrectAnswers, ansCorrectly)
                                startActivity(intent)
                            }
                        }
                    }else{
                        // getting the current question position
                        val question = myQuestionList?.get(myCurrentPosition-1)
                        // check for correct answer
                        if (question!!.correctAns != mySelectedOptionPos){
                            answerView(mySelectedOptionPos,R.drawable.wrong_option_border_bg)
                            Toast.makeText(this, "Wrong Answer, The answer is option ${question.correctAns}", Toast.LENGTH_SHORT).show()
                        }else {
                            Toast.makeText(this, "Correct Answer, Good job !!!", Toast.LENGTH_SHORT).show()
                            ansCorrectly++
                        }
                        answerView(question.correctAns,R.drawable.correct_option_border_bg )
                        if(myCurrentPosition == myQuestionList!!.size){
                           submitBt.text = "FINISH"
                        }else {
                            submitBt.text = "GO TO NEXT QUESTION"
                        }
                        mySelectedOptionPos = 0
                    }
                }
            }
        }
        // a function that get the answer to the question and assign the right background for the option.
        private fun answerView (answer: Int, drawableView: Int){
            val tvOptionOne = findViewById<TextView>(R.id.tvOptionOne)
            val tvOptionTwo = findViewById<TextView>(R.id.tvOptionTwo)
            val tvOptionThree = findViewById<TextView>(R.id.tvOptionThree)
            val tvOptionFour = findViewById<TextView>(R.id.tvOptionFour)
            when (answer){
                1 -> {
                    tvOptionOne.background = ContextCompat.getDrawable(
                        this, drawableView
                    )
                }
                2 -> {
                    tvOptionTwo.background = ContextCompat.getDrawable(
                        this, drawableView
                    )
                }
                3 -> {
                    tvOptionThree.background = ContextCompat.getDrawable(
                        this, drawableView
                    )
                }
                4 -> {
                    tvOptionFour.background = ContextCompat.getDrawable(
                        this, drawableView
                    )
                }
            }
        }
        private fun selectedOpView(tv: TextView, selectedOptionNum: Int){
            defaultOptionView()
            mySelectedOptionPos = selectedOptionNum

            tv.setTextColor(Color.parseColor("#14649F"))
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
            )
        }
}



