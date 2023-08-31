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
import com.example.techookku.datamodel.GridItemModel
import com.example.techookku.datamodel.ServiceDetailModel
import com.example.techookku.ui.theme.colorPrimary
import com.example.techookku.ui.theme.colorPrimaryLight
import com.example.techookku.ui.theme.ghost_white
import com.example.techookku.ui.theme.white


@Composable
fun ServiceListingScreen(
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.background(colorPrimaryLight),
        topBar = {
            TopBar(
                stringResource(id = R.string.service_listing_title).toString(),
                onUpClick = {
                    navController.navigateUp()
                }
            )
        },
    ) { padding ->
        val items = getGridItems();

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(padding)
                .background(colorPrimaryLight),
            contentPadding = PaddingValues(all = dimensionResource(id = R.dimen.card_side_margin))
        ) {
            items(items, key = { message ->
                // Return a stable + unique key for the item
                message.serviceId
            }) { item ->
                GridItemContent(item = item) {
                    navController.navigate("service_detail/${item.serviceId}")
                }
            }
        }
    }
}


@Composable
fun GridItemContent(item: GridItemModel, onItemClick: (GridItemModel) -> Unit) {
    Surface(
        shape = RoundedCornerShape(10.dp).copy(
        ),
        modifier = Modifier.padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .clickable { onItemClick(item) }
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
                text = item.name,
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
public fun TopBar(
    text: String,
    onUpClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(
                text = text,
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
fun getByServiceId(serviceId : String) :  ServiceDetailModel {
    val serviceList: Map<String, ServiceDetailModel> = getServiceListAsMap();
    return serviceList.getValue(serviceId);
}

@Composable
fun getGridItems() : List<GridItemModel> {
    val gridItems = ArrayList<GridItemModel>()
    val serviceList: Map<String, ServiceDetailModel> = getServiceListAsMap();
    serviceList.values.forEach { mapItem ->
        gridItems.add(GridItemModel(mapItem.serviceId, mapItem.imageRes, mapItem.name))
    }
    println(gridItems)
    return gridItems;
}

@Composable
fun getServiceListAsMap() : Map<String, ServiceDetailModel> {
    val serviceMap = mutableMapOf<String, ServiceDetailModel>();
    serviceMap["ro_service"] = ServiceDetailModel("ro_service", "RO Service", "Rs. 500", "Description here", R.drawable.roservice)
    serviceMap["petambulance_service"] = ServiceDetailModel("petambulance_service", "Pet Ambulance", "Rs. 500", "Description here", R.drawable.petambulanceservice)
    serviceMap["it_service"] = ServiceDetailModel("it_service", "IT Service", "Rs. 500", "Description here", R.drawable.itservice)
    serviceMap["ac_service"] = ServiceDetailModel("ac_service", "AC Service", "Rs. 500", "Description here", R.drawable.acservice)
    serviceMap["inservice"] = ServiceDetailModel("inservice", "Inverter Service", "Rs. 500", "Description here", R.drawable.inverterservice)
    serviceMap["plumberservice"] = ServiceDetailModel("plumberservice", "Plumber Service", "Rs. 500", "Description here", R.drawable.plumberservice)
    return serviceMap;
}

@Composable
@Preview(showBackground = true)
fun ServicePreview() {
    ServiceListingScreen(navController = rememberNavController())
}


