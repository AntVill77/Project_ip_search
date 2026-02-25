package com.example.project_ip_search.view

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project_ip_search.viewmodel.IdViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchGameView(viewModel: IdViewModel, navController: NavController){

    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    val games by viewModel.id.collectAsState()

    var text by remember{ mutableStateOf("") }
    var res by remember{ mutableStateOf("Res") }


    Column(
        modifier = Modifier
            //  .background(Color(0xFF000000))
            .padding(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Escribe una ip", fontSize = 20.sp, fontWeight = FontWeight.Normal)

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Label") }
        )
        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        Button(onClick = {
            navController.navigate("Home")
            Log.d("games2","query ${text}")
            viewModel.getIpSingle(text)
            res = text
            text = ""
        }) {
            Text(text = "Buscar")
        }
       /* TextField(
            value = res,
            onValueChange = { text = it },
            label = { Text("Label") }
        )*/
    }

}