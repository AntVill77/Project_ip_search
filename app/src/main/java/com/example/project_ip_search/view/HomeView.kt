package com.example.project_ip_search.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project_ip_search.viewmodel.IdViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: IdViewModel, navController: NavController){
    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ContentHomeView(viewModel, navController)
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHomeView(viewModel:IdViewModel, navController: NavController) {
    val state = viewModel.state
    var text by remember{ mutableStateOf("") }

    Log.d("games2", "homeView state ${state.toString()}")
    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Text(
                text = "IP: ",
                fontWeight = FontWeight.Normal
            )
            Text(
                text = state.ip,
                fontWeight = FontWeight.ExtraBold
            )
        }

        Row {
            Text(
                text = "Type: ",
                fontWeight = FontWeight.Normal
            )
            Text(
                text = state.type,
                fontWeight = FontWeight.ExtraBold
            )
        }

        Row {
            Text(
                text = "City: ",
                fontWeight = FontWeight.Normal
            )

            Text(
                text = state.city.name,
                fontWeight = FontWeight.ExtraBold
            )
        }
        Row {
            Text(
                text = "Continent: ",
                fontWeight = FontWeight.Normal
            )

            Text(
                text = state.continent.name,
                fontWeight = FontWeight.ExtraBold
            )
        }
        Row {
            Text(
                text = "Country: ",
                fontWeight = FontWeight.Normal
            )

            Text(
                text = state.country.name,
                fontWeight = FontWeight.ExtraBold
            )
        }
        Row {
            Text(
                text = "Latitude: ",
                fontWeight = FontWeight.Normal
            )
            Text(
                text = state.location.latitude.toString(),
                fontWeight = FontWeight.ExtraBold
            )

        }

        Row {
            Text(
                text = "Longitud: ",
                fontWeight = FontWeight.Normal
            )
            Text(
                text = state.location.longitude.toString(),
                fontWeight = FontWeight.ExtraBold
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 64.dp))

        Button(onClick = {
            navController.navigate("SearchGameView")
            viewModel.getIpSingle(text)
            text = ""
        }){
            Text(text = "Regresar a busqueda")
        }
    }
}
