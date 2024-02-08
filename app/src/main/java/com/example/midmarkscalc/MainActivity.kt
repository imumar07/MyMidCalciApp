package com.example.midmarkscalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midmarkscalc.ui.theme.MidMarksCalcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MidMarksCalcTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    mainCodeMMC()
                }
            }
        }
    }
}
@Composable
fun mainCodeMMC()
{
    var marks1 by remember {mutableStateOf("")}
    var marks2 by remember { mutableStateOf("") }
    var finalMarks by remember { mutableStateOf("marks are") }
      Column (
          modifier = Modifier.fillMaxSize(),
          verticalArrangement = Arrangement.Top,
          horizontalAlignment = Alignment.CenterHorizontally
      )
      {
          Spacer(modifier = Modifier.height(10.dp))
          Text(text = "Welcome to Mid marks Calculator", fontSize = 20.sp)
          Spacer(modifier = Modifier.height(6.dp))
          Text(text = "Best 80% and rest 20%", fontSize = 14.sp)
          Spacer(modifier = Modifier.height(6.dp))
          OutlinedTextField(
              value = marks1,
              onValueChange ={marks1=it},
              label = { Text(text = "mid 1")}
          )
          Spacer(modifier = Modifier.height(6.dp))
          OutlinedTextField(
              value = marks2,
              onValueChange ={marks2=it},
              label = { Text(text = "mid 2")}
          )
          Spacer(modifier = Modifier.height(6.dp))
          Button(onClick = { finalMarks= calcFinal(marks1,marks2) })
          {
              Text(text = "Click here")
          }
          Spacer(modifier = Modifier.height(8.dp))
          Text(text = finalMarks)
      }
}



@Preview(showBackground = true)
@Composable
fun mainCodeMMcPreview()
{
    mainCodeMMC()
}


fun calcFinal(a:String,b:String):String
{
    var m1=a.toInt();
    var m2=b.toInt();
    if(m2>m1)
    {
        var temp=m1
        m1=m2
        m2=temp
    }
    var ans=m1*0.8+m2*0.2;
    return ans.toString()
}