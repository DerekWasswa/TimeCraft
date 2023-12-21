package com.rosen.timecraft.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rosen.timecraft.ui.theme.Black
import com.rosen.timecraft.ui.theme.TimeCraftTheme
import com.rosen.timecraft.ui.theme.White

@Composable
fun ShoppingCartScreen(
    contentPadding: PaddingValues = PaddingValues()
) {
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
                text = "Shopping Cart",
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
                .background(color = White ,shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingCartScreenPreview() {
    TimeCraftTheme {
        ShoppingCartScreen()
    }
}