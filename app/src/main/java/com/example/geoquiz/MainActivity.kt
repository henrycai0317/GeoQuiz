package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //使用lateinit修飾符號告訴編譯器，會提供非空值的view值
    private lateinit var trueButton:Button
    private lateinit var falseButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //在onCreate()方法調用 setContentView後，所有的視圖物件才會被放入到手機內存中
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        //使用資源ID獲取視圖物件
          trueButton  = findViewById(R.id.true_button)
          falseButton = findViewById(R.id.false_button)
        //設置監聽器
        trueButton.setOnClickListener {
            Toast.makeText(
                this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT
            ).show()
        }

        falseButton.setOnClickListener {
            Toast.makeText(
                this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}