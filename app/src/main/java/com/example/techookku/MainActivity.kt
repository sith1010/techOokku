package com.example.techookku

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {
    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gifplaceholder = findViewById<ImageView>(R.id.gifImageView)
        Glide.with(this)
            .load(R.drawable.peoplepro)
            .into(gifplaceholder)

        // Assuming you have an ImageView with the id "imageView" in your activity_main.xml layout
        //imageView.setImageResource(R.drawable.pplogo.png)
        loginButton = findViewById<Button>(R.id.button13)
        // Assuming you have a Button with the id "loginButton" in your activity_main.xml layout
        loginButton.setOnClickListener {
            val secondActivityIntent = Intent(this, serviceListing::class.java)
            startActivity(secondActivityIntent)
       }
    }}