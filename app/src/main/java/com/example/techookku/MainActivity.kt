package com.example.techookku

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.techookku.ui.theme.TechOokkuTheme
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_start.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gifplaceholder = findViewById<ImageView>(R.id.gifImageView)
        Glide.with(this)
            .load(R.drawable.ezgif_4_d3a14eca72)
            .into(gifplaceholder)
    }
        // Assuming you have an ImageView with the id "imageView" in your activity_main.xml layout
        //imageView.setImageResource(R.drawable.pplogo.png)
        val loginButton = findViewById<Button>(R.id.button13)
        // Assuming you have a Button with the id "loginButton" in your activity_main.xml layout
        loginButton.setOnClickListener {
            val secondActivityIntent = Intent(this, serviceListing::class.java)
            startActivity(secondActivityIntent)
       }
    }
}