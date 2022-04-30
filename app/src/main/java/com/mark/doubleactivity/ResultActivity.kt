package com.mark.doubleactivity

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.net.URI

class ResultActivity : AppCompatActivity() {

    companion object{
        val USER_NAME: String = "USER_NAME"
    }

    lateinit var tv_result : TextView
    lateinit var btn_return: Button
    lateinit var btn_showweb: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tv_result = findViewById(R.id.tv_result)
        btn_return = findViewById(R.id.btn_return)
        btn_showweb = findViewById(R.id.btn_showweb)

        val value : String? = intent.getStringExtra(USER_NAME)
        Log.d("name", value.toString())
        tv_result.text = "Hello! " + value.toString()

        btn_showweb.setOnClickListener{
            if (value != null) {
                showWeb(value)
            }
        }
        btn_return.setOnClickListener{finish()}

    }
    private fun showWeb(value: String){
        val intent : Intent = Intent()
        val uri : Uri = Uri.parse("https://www.google.com/search?q=" + value)
        intent.setAction(ACTION_VIEW)
        intent.setData(uri)
        startActivity(intent)
    }

}