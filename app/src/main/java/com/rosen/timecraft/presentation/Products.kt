package com.rosen.timecraft.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rosen.timecraft.ui.theme.NameBlack
import com.rosen.timecraft.ui.theme.PriceBlack
import com.rosen.timecraft.ui.theme.White

@Composable
fun ProductItemList(products: List<Product>, navController: NavController) {
    LazyColumn {
        itemsIndexed(products) { index, product ->
            if (index % 2 == 0) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    ProductItem(product = product, modifier = Modifier.weight(1f), navController)
                    if (index < products.size - 1) {
                        Spacer(modifier = Modifier.width(16.dp)) // Add spacing between items
                        ProductItem(product = products[index + 1], modifier = Modifier.weight(1f), navController)
                    }
                }
                if (index < products.size - 2) {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        color = NameBlack,
                        thickness = 1.dp
                    )
                }
            }
        }
    }
}

@Composable
fun ProductItem(product: Product, modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .height(300.dp)
            .background(White)
            .padding(16.dp)
            .clickable {
                navController.navigate("productDetails/${product.id}")
            },
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = product.imageResId),
            contentDescription = null,
            modifier = Modifier
                .wrapContentWidth()
                .height(200.dp)
        )

        Text(
            text = product.name,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.labelMedium.copy(
                color = NameBlack,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )
        )

        Text(
            text = "${product.price} $",
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.bodyLarge.copy(
                color = PriceBlack,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

data class Product(
    val id: String,
    val name: String,
    val price: Int,
    val imageResId: Int
)