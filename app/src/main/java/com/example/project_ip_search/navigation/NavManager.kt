package com.example.project_ip_search.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project_ip_search.view.HomeView
import com.example.project_ip_search.view.SearchGameView
import com.example.project_ip_search.viewmodel.IdViewModel

@Composable
fun NavManager(viewModel: IdViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SearchGameView"){
        composable("Home"){
            HomeView(viewModel, navController)
        }
        composable("SearchGameView"){
            SearchGameView(viewModel, navController)
        }
    }
}