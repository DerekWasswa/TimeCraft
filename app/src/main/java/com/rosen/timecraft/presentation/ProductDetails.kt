package com.rosen.timecraft.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rosen.timecraft.R
import com.rosen.timecraft.ui.components.ScrollIndicator
import com.rosen.timecraft.ui.components.TimeCraftButton
import com.rosen.timecraft.ui.theme.Black
import com.rosen.timecraft.ui.theme.CoffeeBrown
import com.rosen.timecraft.ui.theme.NameBlack
import com.rosen.timecraft.ui.theme.TimeCraftTheme
import com.rosen.timecraft.ui.theme.TitleWhite
import com.rosen.timecraft.ui.theme.White
import kotlin.random.Random

@Composable
fun ProductDetails(productId: String?) {

    Column(
        Modifier.fillMaxSize()
    ) {
        Details()
    }
}

@Composable
fun Details() {
    var isFavorite by remember { mutableStateOf(false) }

    val product = getRandomProduct()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.keyboard_backspace
                    ),
                    tint = NameBlack,
                    contentDescription = null
                )
            }

            Text(
                text = product.name,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Black
                ),
            )

            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.keyboard_backspace
                    ),
                    tint = NameBlack,
                    contentDescription = null,
                    modifier = Modifier.alpha(0f)
                )
            }
        }

        Box(
            modifier = Modifier
                .weight(3f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Image(
                    painter = painterResource(id = product.imageResId),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                ScrollIndicator(
                    activeIndex = 1,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
        }

        Box (
            modifier = Modifier
                .weight(2.8f)
                .padding(top = 16.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Black,
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxSize(),
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = product.name,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = TitleWhite,
                                fontSize = 24.sp
                            ),
                        )

                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = rememberRipple(bounded = false),
                                    onClick = { isFavorite = !isFavorite }
                                )
                                .background(CoffeeBrown.copy(alpha = 0.5f), shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                contentDescription = null,
                                tint = if (isFavorite) CoffeeBrown else White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.size(10.dp))

                    Text(
                        text = "${product.price} $",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = CoffeeBrown
                        ),
                    )

                    Spacer(modifier = Modifier.size(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Water tightness",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Light,
                                color = TitleWhite
                            ),
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            text = "WR50 (5 atm)",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Light,
                                color = White
                            ),
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.size(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Features",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Light,
                                color = TitleWhite
                            ),
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            text = "Chronograph, Date",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Light,
                                color = White
                            ),
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.size(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Mechanism",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Light,
                                color = TitleWhite
                            ),
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            text = "Quartz",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Light,
                                color = White
                            ),
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.size(30.dp))

                    TimeCraftButton(
                        text = "Add to cart",
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = { /*TODO*/ }
                    )
                }
            }
        }
    }
}

private fun getRandomProduct(): Product {
    val index = Random.nextInt(1, 10)
    return Product(
        id = System.currentTimeMillis().toString(),
        name = getProduct()[0],
        price = (100 + index), // Generate random prices
        imageResId = getDrawableResourceId("watch$index")
    )
}


@Preview(showBackground = true)
@Composable
fun ProductDetailsPreview() {
    TimeCraftTheme {
        ProductDetails("")
    }
}