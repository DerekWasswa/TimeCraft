package com.rosen.timecraft.navigation

sealed class Route(val route: String) {
    object HomeScreen : Route("home_screen")
    object Favorites : Route("favorites_screen")
    object ShoppingCart : Route("shopping_cart_screen")
    object Account : Route("account_screen")
}