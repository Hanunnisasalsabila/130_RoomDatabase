package com.example.praktikum8.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.praktikum8.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.praktikum8.view.DetailSiswaScreen
import com.example.praktikum8.view.EditSiswaScreen
import com.example.praktikum8.view.EntrySiswaScreen
import com.example.praktikum8.view.HomeScreen
import com.example.praktikum8.view.route.DestinasiDetailSiswa
import com.example.praktikum8.view.route.DestinasiEditSiswa
import com.example.praktikum8.view.route.DestinasiEntry
import com.example.praktikum8.view.route.DestinasiHome


@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier){
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier)
{
    NavHost(navController=navController, startDestination = DestinasiHome.route, modifier = Modifier)
    {
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = { navController.navigate(route = DestinasiEntry.route) },
                navigateToItemUpdate = {
                    navController.navigate(route = "${DestinasiDetailSiswa.route}/${it}")
                }
            )
        }
        composable(DestinasiEntry.route){
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(name = itemIdArg) {
                type = NavType.IntType
            })
        ){
            DetailSiswaScreen(
                navigateBack = {navController.navigateUp()},
                navigateToEditItem ={navController.navigate("${DestinasiEditSiswa.route}/$it")}
            )
        }
        composable(route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEditSiswa.itemIdArg) {
                type = NavType.IntType
            })
        ){
            EditSiswaScreen(
                navigateBack = {navController.popBackStack()},
                onNavigateUp = {navController.navigateUp()}
            )
        }
    }
}