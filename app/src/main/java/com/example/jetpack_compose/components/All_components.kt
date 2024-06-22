package com.example.jetpack_compose.components


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit



@Composable
fun Text_Component(myText:String,size:TextUnit,weight:FontWeight,dpSize:Dp) {

  Text(
    modifier = Modifier.padding(top =dpSize),
    text =myText,style = TextStyle(
    fontSize = size,
    fontWeight = weight,
    color = Color.Black,
  ),
    textAlign = TextAlign.Start
  )
}



