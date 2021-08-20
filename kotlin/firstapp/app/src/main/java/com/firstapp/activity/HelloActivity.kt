package com.firstapp.activity

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.firstapp.R
//import kotlinx.android.synthetic.main.activity_hello.*

class HelloActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        var button = findViewById<Button>(R.id.btnHello)
        button.setOnClickListener() {
            Toast.makeText(this, "Toast Message", Toast.LENGTH_SHORT).show()
        }

//        btnHello.setOnClickListener() {
//
//        }
    }
}