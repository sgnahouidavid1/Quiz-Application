package com.example.quizapplication

object Constants {
    const val UserName: String = "user_name "
    const val TotalQuestions: String = "total_question"
    const val CorrectAnswers: String = "correct_answers"
    // Create a arraylist with questions
    // array list of type questions
    fun getQuestions (): ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()
        val questOne = Questions(
            1,
            "Who is this Celebrity shown in the image below?",
            R.drawable.kanye_img,
            "Kanye",
            "Drake",
            "Jay-Z",
            "Lil Wayne",
            1
        )
        questionsList.add(questOne)
        val questTwo = Questions(
            2,
            "Who is this Celebrity shown in the image below?",
            R.drawable.gambino_img,
            "Gucci Mane",
            "Lebron James",
            "Donald Glover",
            "Magic Johnson",
            3
        )
        questionsList.add(questTwo)
        val questThree= Questions(
            3,
            "Who is this Celebrity shown in the image below?",
            R.drawable.pump_img,
            "Lil Uzi Vert",
            "Lil Nas X",
            "Lil Peep",
            "Lil Pump",
            4
        )
        questionsList.add(questThree)
        val questFour= Questions(
            4,
            "What is the name of the album image below?",
            R.drawable.hb808_img,
            "Graduation",
            "Ye",
            "808s & HeartBreak",
            "My Beautiful",
            3
        )
        questionsList.add(questFour)
        val questFive= Questions(
            5,
            "What is the name of the album image below?",
            R.drawable.sateflight_img,
            "Man on the Moon: The End of Day",
            "Entergalactic",
            "Speedin' Bullet 2 Heaven",
            "Satellite Flight: The Journey to Mother Moon",
            4
        )
        questionsList.add(questFive)
        val questSix= Questions(
            6,
            "What is the name of the album image below?",
            R.drawable.herloss_img,
            "Certified Lover Boy",
            "Views",
            "Her Loss",
            "What a Time to be Alive",
            3
        )
        questionsList.add(questSix)
        val questSeven= Questions(
            7,
            "Name the anime of the image below?",
            R.drawable.rezero_img,
            "Re-Zero",
            "Stein Gate",
            "Attack on Titan",
            "Spice and wolf",
            1
        )
        questionsList.add(questSeven)
        val questEight= Questions(
            8,
            "Name the anime of the image below?",
            R.drawable.berserk_img,
            "Code Geass",
            "Berserk(2016)",
            "Fate/Zero",
            "Made in abyss",
            2
        )
        questionsList.add(questEight)
        val questNine= Questions(
            9,
            "What is the name of the League of legends champion below?",
            R.drawable.rell_img,
            "Quinn",
            "Samira",
            "Rell",
            "Leona",
            3
        )
        questionsList.add(questNine)
        val questTen = Questions(
            10,
            "What is the name of the League of legends champion below?",
            R.drawable.ez_img,
            "Ekko",
            "Ezreal",
            "Lucian",
            "Galio",
            2
        )
        questionsList.add(questTen)
        return questionsList
    }
}