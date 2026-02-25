package com.example.project_ip_search.view

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project_ip_search.viewmodel.IdViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchGameView(viewModel: IdViewModel, navController: NavController){

    val context = LocalContext.current
    var text by remember { mutableStateOf("") }
    val ipRegex = Regex("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|\$)){4}\$")

    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Escribe una ip", fontSize = 20.sp, fontWeight = FontWeight.Normal)

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Label") },
            isError = text.isNotEmpty() && !text.matches(ipRegex)
        )
        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        Button(onClick = {
            if (text == "" )return@Button
            if (text.matches(ipRegex)){
            navController.navigate("Home")
            Log.d("games2","query ${text}")
            viewModel.getIpSingle(text)
            viewModel.items.add(text)
            }else{
                Toast.makeText(context, "Ingrese una ip valida", Toast.LENGTH_SHORT).show()
                text = ""
            }
        }) {
            Text(text = "Buscar")
        }

        LazyColumn {
            itemsIndexed(viewModel.items) { index, value ->

                Text(text = value)

            }
        }
        Spacer(modifier = Modifier.padding(bottom = 32.dp))

        Button(onClick = {
            viewModel.clean()
            viewModel.items.clear()
        }) {
            Text(text = "Limpiar Ips")
        }
    }

}