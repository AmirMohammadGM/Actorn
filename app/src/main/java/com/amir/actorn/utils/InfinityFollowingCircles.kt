package com.amir.actorn.utils

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun InfinitelyFlowingCircles()
{
     val primaryColor = MaterialTheme.colors.primary
     val frontCircle = primaryColor.copy(0.75f)
     val midCircle = primaryColor.copy(0.50f)
     val backCircle = primaryColor.copy(0.25f)
     DrawCircleOnCanvas(
               scale = scaleInfiniteTransition(targetValue = 2f , durationMillis = 600) ,
               color = backCircle ,
               radiusRatio = 4f
     )
     DrawCircleOnCanvas(
               scale = scaleInfiniteTransition(targetValue = 2.5f , durationMillis = 800) ,
               color = midCircle ,
               radiusRatio = 6f
     )
     DrawCircleOnCanvas(
               scale = scaleInfiniteTransition(targetValue = 3f , durationMillis = 1000) ,
               color = frontCircle ,
               radiusRatio = 12f
     )
}

@Composable
private fun DrawCircleOnCanvas(
          scale : Float ,
          color : Color ,
          radiusRatio : Float ,
)
{
     Canvas(
               modifier = Modifier
                         .fillMaxSize()
                         .graphicsLayer {
                              scaleX = scale
                              scaleY = scale
                         }
     ) {
          val canvasWidth = size.width
          val canvasHeight = size.height
          drawCircle(
                    color = color ,
                    center = Offset(
                              x = canvasWidth / 2 ,
                              y = canvasHeight / 2
                    ) ,
                    radius = size.minDimension / radiusRatio ,
          )
     }
}

@Composable
private fun scaleInfiniteTransition(
          initialValue : Float = 0f ,
          targetValue : Float ,
          durationMillis : Int ,
) : Float
{
     val infiniteTransition = rememberInfiniteTransition()
     val scale : Float by infiniteTransition.animateFloat(
               initialValue = initialValue ,
               targetValue = targetValue ,
               animationSpec = infiniteRepeatable(
                         animation = tween(durationMillis , easing = LinearEasing) ,
                         repeatMode = RepeatMode.Reverse
               )
     )
     return scale
}