package com.example.intentsapp.views

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.intentsapp.components.BottomNav
import com.example.intentsapp.navigation.NavManager
import com.example.intentsapp.navigation.Routes

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView() {
    val navController = rememberNavController()
    val navigationRoutes = listOf(
        Routes.PhoneView,
        Routes.SmsView,
        Routes.EmailView,
    )

    Scaffold(
        bottomBar = { BottomNav(navHostController = navController, routes = navigationRoutes) }
    ) {
        NavManager(navController)
    }
}