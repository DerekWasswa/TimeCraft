package com.rosen.timecraft.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.rosen.timecraft.R
import com.rosen.timecraft.ui.theme.Black
import com.rosen.timecraft.ui.theme.TimeCraftTheme
import com.rosen.timecraft.ui.theme.White

@Composable
fun FavoritesScreen(
    contentPadding: PaddingValues = PaddingValues(),
    navController: NavController
) {
    var products by remember { mutableStateOf<List<Product>>(emptyList()) }
    
    LaunchedEffect(true) {
        if (products.isEmpty()) {
            products = generateProductList()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black)
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Favorites",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = White,
                    fontSize = 30.sp,
                ),
                textAlign = TextAlign.Center
            )
        }

        Box(
            modifier = Modifier
                .weight(8f)
                .fillMaxWidth()
                .background(
                    color = White,
                    shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                )
                .padding(top = 10.dp, start = 16.dp, end = 16.dp, bottom = 56.dp)
        ) {
            ProductItemList(products = products, navController = navController)
        }
    }
}

private fun generateProductList(): List<Product> {
    return (1..10).map {
        Product(
            id = it.toString(),
            name = getProduct()[it - 1],
            price = (100 + it), // random prices
            imageResId = getDrawableResourceId("watch$it")
        )
    }
}

fun getDrawableResourceId(name: String): Int {
    return try {
        R.drawable::class.java.getField(name).getInt(null)
    } catch (e: Exception) {
        R.drawable.ic_launcher_foreground
    }
}

fun getProduct() : List<String> {
    return listOf(
        "Rolex",
        "Omega",
        "Seiko",
        "Casio",
        "Citizen",
        "Fossil",
        "Swatch",
        "Bulova",
        "Cartier",
        "Breitling"
    )
}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    TimeCraftTheme {
        val navController = rememberNavController()
        FavoritesScreen(navController = navController)
    }
}