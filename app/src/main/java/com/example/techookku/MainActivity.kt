package com.example.techookku

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.example.techookku.navigation.Navigation
import com.example.techookku.ui.theme.TechOokkuTheme


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreenMain()
        }
    }

    @Composable
    public fun LoginScreenMain() {
        TechOokkuTheme {
            Surface(color = MaterialTheme.colorScheme.background) {
                Navigation()
            }
        }
    }

}


