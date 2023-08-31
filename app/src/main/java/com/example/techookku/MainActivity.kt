package com.example.techookku

import android.os.Bundle
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
            SplashScreenMain()
        }
    }

    @Composable
    public fun SplashScreenMain() {
        TechOokkuTheme {
            Surface(color = MaterialTheme.colorScheme.background) {
                Navigation()
            }
        }
    }

}


