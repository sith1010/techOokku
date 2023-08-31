import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.techookku.R
import com.example.techookku.datamodel.ServiceDetailModel
import com.example.techookku.ui.theme.colorPrimaryLight
import com.example.techookku.view.TopBar

@Composable
fun ServiceDetailScreen(navController: NavController,
                        serviceItem: ServiceDetailModel) {

    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.background(colorPrimaryLight),
        topBar = {
            TopBar(
                serviceItem.name,
                onUpClick = {
                    navController.navigateUp()
                }
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(modifier = Modifier.padding(start = 16.dp)) {
                Image(
                    painter = painterResource(id = serviceItem.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(200.dp)
                        .padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = serviceItem.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }


            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.padding(start = 16.dp)) {

                Text(
                    text = serviceItem.price,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }


            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = serviceItem.description,
                    fontSize = 14.sp
                )
            }


            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                Button(
                    colors = ButtonDefaults.buttonColors(colorPrimaryLight),
                    onClick = {
                        Toast.makeText(context, "Service added to cart.", Toast.LENGTH_LONG).show() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Add to Cart")
                }
            }

        }
    }

}


@Composable
@Preview
fun ServiceDetailPreview() {
    ServiceDetailScreen(navController = rememberNavController(), ServiceDetailModel("petambulance_service","Pet Ambulance Service", "Rs. 500", "We, along with our partners, provide the ambulance free service for pets.", R.drawable.petambulanceservice))
}
