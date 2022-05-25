package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.viewbinding.ViewBinding
import com.example.geoquiz.databinding.ActivityMainBinding

private  val TAG = MainActivity::class.java.simpleName as String

class MainActivity : AppCompatActivity() {

    //使用lateinit修飾符號告訴編譯器，會提供非空值的view值
    private lateinit var viewBinding:ActivityMainBinding

    private val quizViewModel:QuizViewModel by lazy {
        ViewModelProvider(this).get(QuizViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, " onCreate(Bundle?) called")
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        //在onCreate()方法調用 setContentView後，所有的視圖物件才會被放入到手機內存中
        setContentView(viewBinding.root)


        initView()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    private fun initView() {
        //設置監聽器
        viewBinding.trueButton.setOnClickListener {
            checkAnswer(true)
        }

        viewBinding.falseButton.setOnClickListener {
            checkAnswer(false)
        }


        viewBinding.nextButton.setOnClickListener {
            quizViewModel.moveToNext()
            questionUpdate()
        }

        viewBinding.prevButton.setOnClickListener {
            quizViewModel.moveToPrevd()
            questionUpdate()
        }

        questionUpdate()

    }

    private fun questionUpdate() {
        val questionTextResId = quizViewModel.currentQuestionText
        viewBinding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer : Boolean){
        val correctAnswer = quizViewModel.currentQuestionAnswer

        val messageResId = if(userAnswer == correctAnswer) {
            R.string.correct_toast
        } else{
            R.string.incorrect_toast
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show()
    }
}