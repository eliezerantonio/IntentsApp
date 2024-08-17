package com.example.intentsapp.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.intentsapp.navigation.Routes


@Composable
fun BottomNav(navHostController: NavHostController, routes: List<Routes>) {

    BottomAppBar() {
        NavigationBar(containerColor = Color.White) {
            val currentRoutes = CurrentRoute(navHostController)
            routes.forEach { item ->
                NavigationBarItem(
                    selected = currentRoutes == item.route,
                    onClick = { navHostController.navigate(item.route) },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = "",
                            tint = Color.Blue
                        )
                    }, label = {
                        Text(item.title)
                    }, alwaysShowLabel = true
                )
            }
        }
    }

}


@Composable
fun CurrentRoute(navHostController: NavHostController): String? {


    val current by navHostController.currentBackStackEntryAsState()
    return current?.destination?.route
}