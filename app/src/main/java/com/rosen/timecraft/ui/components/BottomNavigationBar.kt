package com.rosen.timecraft.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rosen.timecraft.R
import com.rosen.timecraft.navigation.Route
import com.rosen.timecraft.ui.theme.Black
import com.rosen.timecraft.ui.theme.TimeCraftTheme


@Composable
fun BottomNavigationBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val navBarScreens = listOf(
        Route.HomeScreen,
        Route.Favorites,
        Route.ShoppingCart,
        Route.Account
    )

    if (currentDestination?.route in navBarScreens.map { it.route })
        NavigationBar(
            containerColor = Black,
        ) {

            AddNavigationBarItem(
                iconResId = R.drawable.search_fill,
                destinationRoute = Route.HomeScreen,
                currentDestination = currentDestination,
                navController = navController
            )

            AddNavigationBarItem(
                iconResId = R.drawable.favorite_fill,
                destinationRoute = Route.Favorites,
                currentDestination = currentDestination,
                navController = navController
            )

            AddNavigationBarItem(
                iconResId = R.drawable.shopping_bag,
                destinationRoute = Route.ShoppingCart,
                currentDestination = currentDestination,
                navController = navController
            )

            AddNavigationBarItem(
                iconResId = R.drawable.person_fill,
                destinationRoute = Route.Account,
                currentDestination = currentDestination,
                navController = navController
            )

        }
}


@Composable
private fun RowScope.AddNavigationBarItem(
    iconResId: Int,
    destinationRoute: Route,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        icon = {
            Icon(imageVector = ImageVector.vectorResource(id = iconResId), contentDescription = null)
        },
        selected = currentDestination?.route == destinationRoute.route,
        onClick = {
            navController.navigate(destinationRoute.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    TimeCraftTheme {
        val navController = rememberNavController()
        BottomNavigationBar(navController = navController)
    }
}