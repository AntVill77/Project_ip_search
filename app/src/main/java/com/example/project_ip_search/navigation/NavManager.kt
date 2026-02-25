package com.example.project_ip_search.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.project_ip_search.view.DetailView
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
        composable("DetailView/{id}", arguments = listOf(
            navArgument("id") { type = NavType.IntType }
        )  ){
            val id = it.arguments?.getString("id") ?: ""
            DetailView(viewModel, navController, id)
        }
        composable("SearchGameView"){
            SearchGameView(viewModel, navController)
        }
    }
}