package com.rosen.timecraft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rosen.timecraft.navigation.Route
import com.rosen.timecraft.presentation.AccountScreen
import com.rosen.timecraft.presentation.FavoritesScreen
import com.rosen.timecraft.presentation.HomeScreen
import com.rosen.timecraft.presentation.ProductDetails
import com.rosen.timecraft.presentation.ShoppingCartScreen
import com.rosen.timecraft.ui.components.BottomNavigationBar
import com.rosen.timecraft.ui.theme.TimeCraftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimeCraftTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(navController = navController) }
                ) { contentPadding ->

                    NavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colorScheme.background),
                        navController = navController,
                        startDestination = Route.HomeScreen.route
                    ) {
                        composable(route = Route.HomeScreen.route) {
                            HomeScreen(contentPadding = contentPadding)
                        }

                        composable(route = Route.Favorites.route) {
                            FavoritesScreen(contentPadding = contentPadding, navController = navController)
                        }

                        composable(route = Route.ShoppingCart.route) {
                            ShoppingCartScreen(contentPadding = contentPadding)
                        }

                        composable(route = Route.Account.route) {
                            AccountScreen(contentPadding = contentPadding)
                        }

                        composable(route = "productDetails/{productId}") { backStackEntry ->
                            val productId = backStackEntry.arguments?.getString("productId")
                            ProductDetails(productId = productId)
                        }
                    }

                }
            }
        }
    }
}