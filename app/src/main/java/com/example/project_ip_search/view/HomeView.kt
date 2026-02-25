package com.example.project_ip_search.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project_ip_search.state.IpState
import com.example.project_ip_search.viewmodel.IdViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: IdViewModel) {
    //val id by viewModel.id.collectAsState()
    val state = viewModel.state
    var text by remember{ mutableStateOf("") }
    var res by remember{ mutableStateOf("Res") }

   // Log.d("games2", "homeView ${id.toString()}")
    Log.d("games2", "homeView state ${state.toString()}")
   // LazyColumn {
      //  items(id){item ->
    Column(
        modifier = Modifier
          //  .background(Color(0xFF000000))
            .padding(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Label") }
        )

        Button(onClick = {
            viewModel.getIpSingle()
            res = text
            text = ""
        }){
            Text(text = "Search")
        }

        TextField(
            value = res,
            onValueChange = { text = it },
            label = { Text("Label") }
        )
        Text(
            text = state.ip,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = state.status,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = state.type,
            fontWeight = FontWeight.ExtraBold
        )
    }
     //   }
   // }
}


/* Scaffold(
     topBar = {
         MainTopBar(title = "API GAMES", onClickBackButton = {}) {
             navController.navigate("SearchGameView")
         }
     }
 ) {
     ContentHomeView(viewModel, it, navController)
 }*/

//}

/*@Composable
fun ContentHomeView(viewModel: GamesViewModel, pad:PaddingValues, navController: NavController){
    val games by viewModel.games.collectAsState()
    Log.d("games2", games.toString())
    LazyColumn(
        modifier = Modifier
            .padding(pad)
            .background(Color(CUSTOM_BLACK))
    ){
        items(games){ item ->
            CardGame(item) {
                navController.navigate("DetailView/${item.id}")
            }
            Text(text = item.name,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp)
            )

        }
    }*/
//}