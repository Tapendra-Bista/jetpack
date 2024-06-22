package com.example.jetpack_compose.dashboard

import android.annotation.SuppressLint

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Create
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose.R
import com.example.jetpack_compose.components.Text_Component
import com.example.jetpack_compose.ui.theme.blue

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun Dashboard_page(navController: NavHostController, name: String?, animal: String?) {
Scaffold {
    Surface(modifier = Modifier.padding(horizontal = 15.dp)) {

        Column(

            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,

            ) {
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    modifier = Modifier.padding(top = 25.dp),
                    text = "Welcome $name 😍", fontSize = 20.sp, fontWeight = FontWeight.Bold,)
                Image(
                    painter = painterResource(id = R.drawable.kotlin),
                    contentDescription = "IMage logo"
                )

            }
            Text_Component(
                myText = "Thank You! From Sharing Your Data",
                size = 20.sp,
                weight = FontWeight.Normal,
                dpSize = 33.dp
            )
            Text_Component(
                myText = if (animal=="cat") "Your are cat Lover 🐈" else  "Your are dog Lover 🐶",
                size = 20.sp,
                weight = FontWeight.Normal,
                dpSize = 33.dp
            )

            Spacer(modifier = Modifier.height(30.dp))
            Card (
                modifier = Modifier
                    .padding(8.dp)
                    .size(height = 220.dp, width = 350.dp)
            ) {
Icon(
modifier = Modifier.padding(15.dp),
    imageVector = Icons.Sharp.Create , contentDescription = "Icon create")
Text(
    modifier = Modifier.padding(15.dp),
    text ="If $animal could talk they'd probably just ask for more treats." , style = TextStyle(fontSize = 23.sp)
)
                Icon(
                    modifier = Modifier.padding(15.dp),
                    imageVector = Icons.Sharp.Create , contentDescription = "Icon create")
            }
            Spacer(modifier =Modifier.heightIn(20.dp) )
            TextButton(

                colors = ButtonDefaults.buttonColors(blue),
                shape = RoundedCornerShape(9.dp),
                modifier = Modifier
                    .size(height = 70.dp, width = 300.dp)
                    .padding(top = 20.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                onClick ={
                    navController.popBackStack()
                } ) {
                Text(text ="Go Back" )
            }
        }
    }
}

}

@Preview
@Composable
private fun DashboardPreview () {
    Dashboard_page(rememberNavController(), "Tapendra", "cat")
}