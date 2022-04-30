package com.mark.doubleactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {


    

    lateinit var et_name : EditText
    lateinit var  btn_result: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initID()

        btn_result.setOnClickListener{showResult()}
    }

    private fun initID(){
        et_name = findViewById(R.id.et_name)
        btn_result = findViewById(R.id.btn_result)
    }
    private fun showResult(){
        val intent = Intent()
        intent.putExtra(ResultActivity.USER_NAME, et_name.text.toString())
        intent.setClass(this, ResultActivity::class.java)
        startActivity(intent)
    }
}