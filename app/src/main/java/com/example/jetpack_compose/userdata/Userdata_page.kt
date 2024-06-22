package com.example.jetpack_compose.userdata
import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons.Sharp
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material.icons.sharp.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose.R
import com.example.jetpack_compose.components.Text_Component
import com.example.jetpack_compose.routes.Routes
import com.example.jetpack_compose.ui.theme.blue


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun UserData_page(navController: NavHostController) {

Scaffold(
    topBar = {
      TopAppBar(
          { Text(text = "App Bar")},
       modifier = Modifier
           .background(blue)
           .verticalScroll(state = rememberScrollState()),
          colors = TopAppBarDefaults.topAppBarColors(blue).copy(
              actionIconContentColor =Color.White,
           titleContentColor = Color.White,
             ),
          actions = {
         Row (
             modifier = Modifier
                 .background(Color.Transparent)
                 .width(100.dp)
                 .absolutePadding(right = 9.dp),
             horizontalArrangement = Arrangement.SpaceBetween

         ) {
             Icon(imageVector = Sharp.Menu, contentDescription ="menu" )
             Icon(imageVector = Sharp.Person, contentDescription ="person" )
             Icon(imageVector = Sharp.Info, contentDescription ="info" )
         }
          },


      )


    }
) {

    Surface(

        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxSize()
            .padding(top = 80.dp)
            .padding(bottom = 15.dp)
            .safeContentPadding(), color = Color.Transparent
    ) {

        Column {

            Row(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,

                ) {

                Text(
                    modifier = Modifier.padding(top = 25.dp),
                    text = "Hi there \uD83D\uDE06", fontSize = 25.sp, fontWeight = FontWeight.Bold,
                )
                Image(
                    painter = painterResource(id = R.drawable.kotlin),
                    contentDescription = "IMage logo"
                )
            }
            Text_Component(
                myText = "Let's learn about you !",
                size = 23.sp,
                weight = FontWeight.Normal,
                dpSize = 30.dp
            )
            Text_Component(
                myText = "This app will be prepare a details page based on input provided you !",
                size = 18.sp,
                weight = FontWeight.Normal,
                dpSize = 25.dp
            )
            Text_Component(
                myText = "Name",
                size = 20.sp,
                weight = FontWeight.Normal,
                dpSize = 30.dp
            )
            var text by remember {
                mutableStateOf("")
            }
            var animal  by remember {
                mutableStateOf("")
            }
            val localFocusManager = LocalFocusManager.current
            OutlinedTextField(

                label = {
                    Text(text ="Name" )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                value = text, onValueChange = { text = it},
                placeholder = {
                    Text(text ="Enter Your Name" )
                },
                leadingIcon = {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Sharp.Person , contentDescription ="Person", )
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Text,


                    ),
                keyboardActions = KeyboardActions {
                    localFocusManager.clearFocus()
                }



            )
            Text_Component(
                myText = "What do you like ",
                size = 20.sp,
                weight = FontWeight.Normal,
                dpSize = 30.dp
            )
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(top = 20.dp)

            ){



                Card(
                    border = BorderStroke(1.dp,if (animal=="cat")Color.Green else Color.Transparent),
                    modifier = Modifier
                        .padding(10.dp)
                        .size(height = 150.dp, width = 150.dp)
                        .weight(1f)
                    , onClick = {
                        localFocusManager.clearFocus()
                        animal = "cat"
                    }


                    , shape = RoundedCornerShape(20.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),

                        painter = painterResource(id = R.drawable.cat ), contentDescription ="cat" )
                }

                Card(
                    border = BorderStroke(1.dp,if (animal=="dog")Color.Green else Color.Transparent),
                    modifier = Modifier
                        .padding(10.dp)
                        .size(height = 150.dp, width = 150.dp)
                        .weight(1f),

                    shape = RoundedCornerShape(20.dp)
                    , onClick = {
                        localFocusManager.clearFocus()
                        animal= "dog"
                    }
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(0.dp),

                        painter = painterResource(id = R.drawable.dog ), contentDescription ="dog" )
                }


            }
            Spacer(modifier = Modifier.height(50.dp))


            if (animal!="" &&text!=""){
                TextButton(
                    colors =ButtonDefaults.buttonColors(blue),
                    shape = RoundedCornerShape(9.dp),
                    modifier = Modifier
                        .size(height = 70.dp, width = 300.dp)
                        .padding(top = 20.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    onClick ={

                        navController.navigate("${Routes.DASHBOARD_PAGE_ROUTE}/${text}/${animal}")
                    } ) {
                    Text(text ="Submit" )
                }
            }
        }
    }

}

}

@Preview
@Composable
private fun UserData_page_Preview() {
   UserData_page(rememberNavController())
}

