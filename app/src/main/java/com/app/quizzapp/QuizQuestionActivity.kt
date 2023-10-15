package com.app.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
val qlist: ArrayList<Question> = Constants.getQuestions()
var id =1
var isWrongClicked: Boolean = false
var score:Int = 0
var curOpt: Int? = null
class QuizQuestionActivity : AppCompatActivity() {
//    private var btnSub : Button ? = null
    private var progBar : ProgressBar ? = null
    private var tvProgress : TextView ? = null
    private var tvQuestion : TextView? = null
    private var imgView :ImageView ? = null

    private var optOne : TextView?=null
    private var optTwo : TextView?=null
    private var optThree : TextView?=null
    private var optFour : TextView?=null
    private var btnsub:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

//        val qlist: ArrayList<Question> = Constants.getQuestions()
//        Log.i("Question list size is","${qlist.size}")
        progBar = findViewById(R.id.progBar)
        tvProgress=findViewById(R.id.tvProg)
        tvQuestion=findViewById(R.id.tv_question)
        imgView =findViewById(R.id.iv_image)
        val btnSub:Button = findViewById(R.id.btnSub)

        optOne= findViewById(R.id.opt1)
        optTwo = findViewById(R.id.opt2)
        optThree = findViewById(R.id.opt3)
        optFour=findViewById(R.id.opt4)
        btnsub=findViewById(R.id.btnSub)


        //initial question page
        tvQuestion?.text = qlist[0].question
        imgView?.setImageDrawable(ContextCompat.getDrawable(this,qlist[0].image))
        optOne?.text = qlist[0].opt1
        optTwo?.text = qlist[0].opt2
        optThree?.text = qlist[0].opt3
        optFour?.text = qlist[0].opt4
        progBar?.progress=qlist[0].id
        tvProgress?.text= "1/9"

        //remaining questions
        btnSub.setOnClickListener {
            if(id < qlist.size && curOpt != null){
                Disp(qlist[id])
                id += 1
                optOne?.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
                optTwo?.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
                optThree?.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
                optFour?.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
                isWrongClicked=false
                curOpt=null
            } else{
                Toast.makeText(this,"Please Select Your answer!",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun Disp(i:Question){
        tvQuestion?.text = i.question
        imgView?.setImageDrawable(ContextCompat.getDrawable(this,i.image))
        optOne?.text = i.opt1
        optTwo?.text =i.opt2
        optThree?.text = i.opt3
        optFour?.text =i.opt4
        progBar?.progress = i.id
        tvProgress?.text= "${i.id}/9"
        if(i.id == 9){
            btnsub?.text="Submit"

            btnsub?.setOnClickListener{
                var intent = Intent(this,FinalScore::class.java)
                intent.putExtra("final_score", "$score")
                startActivity(intent)
            }
        }
    }


    fun OnClick(view:View) {
        //clicked opt 2 ,
        //correct ans 1 , change 2 to red 1 to green bg (qlist[id].correctans)

        val selOpt: TextView? = (view as TextView)

        if (selOpt == optOne) {
            curOpt = 1
        } else if (selOpt == optTwo) {
            curOpt = 2
        } else if (selOpt == optThree) {
            curOpt = 3
        } else if (selOpt == optFour) {
            curOpt = 4
        }
        var cid = id - 1
        var correctAns = qlist[cid].correctAns
        when (correctAns) {
            1 -> {
                optOne?.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }

            2 -> {
                optTwo?.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }

            3 -> {
                optThree?.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }

            4 -> {
                optFour?.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }
        }
        if (!isWrongClicked) {
            if (curOpt != correctAns) {
                when (curOpt) {
                    1 -> optOne?.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)

                    2 -> optTwo?.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)

                    3 -> optThree?.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)

                    4 -> optFour?.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                }
                isWrongClicked=true
            }
            else if (curOpt==correctAns){
                isWrongClicked=true
                score += 1
            }
        }
    }

}