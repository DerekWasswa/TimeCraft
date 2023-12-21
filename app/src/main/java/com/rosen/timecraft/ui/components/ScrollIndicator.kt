package com.rosen.timecraft.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rosen.timecraft.ui.theme.Black
import com.rosen.timecraft.ui.theme.White

@Composable
fun ScrollIndicator(activeIndex: Int, modifier: Modifier) {
    Row(
        modifier = modifier,
    ) {
        (0..2).forEachIndexed { index, _ ->
            Dot(color = Black, isActive = index == activeIndex)
            if (index < 3 - 1) {
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}

@Composable
fun Dot(color: Color, isActive: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.height(12.dp)
    ) {
        if (isActive) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(color = White)
                    .border(width = (1).dp, color = color, shape = CircleShape)
            ) {
                Box(
                    modifier = Modifier
                        .size(4.dp)
                        .clip(CircleShape)
                        .background(color = color)
                        .align(Alignment.Center)
                )
            }
        } else {
            Box(
                modifier = Modifier
                    .size(4.dp)
                    .clip(CircleShape)
                    .background(color = color)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}


@Preview
@Composable
fun ColoredDotsIndicatorPreview() {
    ScrollIndicator(activeIndex = 1, modifier = Modifier.padding(16.dp))
}

@Preview
@Composable
fun DotPreview() {
    Dot(color = Color.Red, isActive = true)
}