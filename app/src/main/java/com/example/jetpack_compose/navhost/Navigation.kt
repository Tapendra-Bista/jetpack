package com.example.jetpack_compose.navhost

import androidx.compose.runtime.Composable

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpack_compose.dashboard.Dashboard_page
import com.example.jetpack_compose.routes.Routes
import com.example.jetpack_compose.userdata.UserData_page



@Composable
fun Navigation_page() {
   val navController = rememberNavController()
   NavHost(navController =navController , startDestination = Routes.USERDATA_PAGE_ROUTE) {
      composable(Routes.USERDATA_PAGE_ROUTE){
         UserData_page(navController)
      }
      composable("${Routes.DASHBOARD_PAGE_ROUTE}/{name}/{animal}", arguments = listOf(
         navArgument("name"){type = NavType.StringType},
                 navArgument("animal"){type = NavType.StringType}
      )){
      val name =   it.arguments?.getString("name")
         val animal =   it.arguments?.getString("animal")

       Dashboard_page(navController,name,animal)


      }
   }
}