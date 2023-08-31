package com.example.techookku.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.techookku.R
import com.example.techookku.navigation.Screen
import com.example.techookku.ui.theme.colorPrimary
import com.example.techookku.ui.theme.colorPrimaryLight
import com.example.techookku.ui.theme.ghost_white
import com.example.techookku.ui.theme.white


data class GridItem(val imageResId: Int, val text: String)

@Composable
fun ServiceListing(
    navController: NavController

) {
    Scaffold(
        modifier = Modifier.background(colorPrimaryLight),
        topBar = {
            GalleryTopBar(
                onUpClick = {
                    navController.navigateUp()
                }
            )
        },
    ) { padding ->
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
            modifier = Modifier.padding(padding).background(colorPrimaryLight),
            contentPadding = PaddingValues(all = dimensionResource(id = R.dimen.card_side_margin))
        ) {
            items(items) { item ->
                GridItemContent(item = item) {
                    navController.navigate(Screen.WelcomeScreen.route)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GalleryTopBar(
    onUpClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(
                stringResource( id = R.string.service_listing_title),
                color = white,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily(Font(R.font.dmsansregular)),
                letterSpacing = 2.sp,
                modifier = Modifier.padding(all = 10.dp))
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = colorPrimary ),
        modifier = modifier
            .statusBarsPadding(),
        navigationIcon = {
            IconButton(onClick = onUpClick) {
                Icon(
                    Icons.Filled.ArrowBack,
                    tint = white,
                    contentDescription = null
                )
            }
        },
    )
}

@Composable
@Preview(showBackground = true)
fun ServicePreview() {
    ServiceListing(navController = rememberNavController())
}
