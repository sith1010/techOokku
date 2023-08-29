package com.example.techookku.view



import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.techookku.R
import com.example.techookku.navigation.Screen
import com.example.techookku.ui.theme.colorPrimary
import com.example.techookku.ui.theme.colorPrimaryLight
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(navController: NavController) = Box(
    Modifier
        .fillMaxWidth()
        .fillMaxHeight()
) {

    val scale = remember {
        androidx.compose.animation.core.Animatable(0.0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(800, easing = {
                OvershootInterpolator(4f).getInterpolation(it)
            })
        )
        delay(2000)
        navController.navigate(Screen.LoginScreen.route) {
            popUpTo(Screen.WelcomeScreen.route) {
                inclusive = true
            }
        }
    }
    val listColors = listOf(colorPrimaryLight, colorPrimary)
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().background(Brush.horizontalGradient(listColors))
    ){
        Image(
            painter = painterResource(id = R.drawable.pplogo),
            contentDescription = "",
            alignment = Alignment.Center, modifier = Modifier
                .fillMaxSize().padding(40.dp)
                .scale(scale.value)
        )
    }


}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    WelcomeScreen(navController = rememberNavController())
}