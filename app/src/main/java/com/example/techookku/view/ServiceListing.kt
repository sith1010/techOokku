package com.example.techookku.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.techookku.R
import com.example.techookku.navigation.Screen
import com.example.techookku.ui.theme.colorPrimary
import com.example.techookku.ui.theme.colorPrimaryLight
import com.example.techookku.ui.theme.ghost_white


data class GridItem(val imageResId: Int, val text: String)

@Composable
fun ServiceListing(
    navController: NavController
) {
    ConstraintLayout {

        val (logoimageref, serviceref) = createRefs()

        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .height(280.dp)
                .background(colorPrimary)
                .constrainAs(logoimageref) {
                    top.linkTo(serviceref.top)
                    bottom.linkTo(serviceref.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
            Header("Services Offered")
        }

        Surface(
            color = colorPrimaryLight,
            shape = RoundedCornerShape(40.dp).copy(
                bottomStart = ZeroCornerSize,
                bottomEnd = ZeroCornerSize
            ),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
                .constrainAs(serviceref) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
                    .background(colorPrimaryLight)
            ) {
                val items = listOf(
                    GridItem(R.drawable.roservice, "RO Service"),
                    GridItem(R.drawable.petambulanceservice, "Pet Ambulance"),
                    GridItem(R.drawable.itservice, "IT Service"),
                    GridItem(R.drawable.acservice, "AC Service"),
                    GridItem(R.drawable.inverterservice, "Inverter Service"),
                    GridItem(R.drawable.plumberservice, "Plumber Service"),
                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),

                    // content padding
                    contentPadding = PaddingValues(
                        start = 12.dp,
                        top = 16.dp,
                        end = 12.dp,
                        bottom = 16.dp
                    )
                ) {
                    items(items) { item ->
                        GridItemContent(item = item) {
                            navController.navigate(Screen.WelcomeScreen.route)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun GridItemContent(item: GridItem, onItemClick: () -> Unit) {
    Surface(
        shape = RoundedCornerShape(10.dp).copy(
        ),
        modifier = Modifier.padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .clickable { onItemClick() }
                .padding(10.dp)
                .fillMaxWidth()

        ) {
            Image(
                painter = painterResource(id = item.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(ghost_white)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = item.text,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ServicePreview() {
    ServiceListing(navController = rememberNavController())
}