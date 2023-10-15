package com.app.quizzapp

object Constants {

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val q1 = Question(
            1,"What country does this flag belong to ?" ,R.drawable.ic_flag_of_australia,
            "Argentina","Armenia","Australia","Austria",3
        )
        val q2 = Question(
            2,"What country does this flag belong to ?",R.drawable.ic_flag_of_brazil,"Bolivia","Brazil",
            "Bosnia","Belgium",2
        )

        val q3 = Question(
            3 , "What country does this flag belong to ?" , R.drawable.ic_flag_of_belgium, "Belgium","Germany","Spain",
            "Portugal" , 1
        )
        val q4 = Question(
            4 , "What country does this flag belong to ?" , R.drawable.ic_flag_of_india,"India" , "Indonesia","Nigeria",
            "Srilanka",1
        )
        val q5 =Question(
            5, "What country does this flag belong to ?",R.drawable.ic_flag_of_argentina,"South Africa","Sudan","UAE","Argentina"
            ,4
        )

        val q6 =Question(
            6 , "What country does this flag belong to ?",R.drawable.ic_flag_of_denmark, "USA","Australia","Denmark","Canada",
            3
        )

        val q7 = Question(
            7 , "What country does this flag belong to ?",R.drawable.ic_flag_of_germany,"Spain","Ukraine","Russia","Germany",4
        )

        val q8 = Question(
            8 , "What country does this flag belong to ?" ,R.drawable.ic_flag_of_kuwait,"China","Kuwait","Nepal","Kazakastan",2
        )
        val q9 = Question(9,"What country does this flag belong to ?",R.drawable.ic_flag_of_fiji,"Fiji","Leabanon","Mauritius","Maldives",1

        )

        questionList.add(q1)
        questionList.add(q2)
        questionList.add(q3)
        questionList.add(q4)
        questionList.add(q5)
        questionList.add(q6)
        questionList.add(q7)
        questionList.add(q8)
        questionList.add(q9)

        return questionList
    }
}