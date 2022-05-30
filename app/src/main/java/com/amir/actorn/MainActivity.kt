package com.amir.actorn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.amir.actorn.navigation.AppNavigation
import com.amir.actorn.ui.theme.ActornTheme

class MainActivity : ComponentActivity()
{
     override fun onCreate(savedInstanceState : Bundle?)
     {
          super.onCreate(savedInstanceState)
          WindowCompat.setDecorFitsSystemWindows(window , false)
          setContent {
               ActornTheme {
                    // A surface container using the 'background' color from the theme
                    ProvideWindowInsets {
                         AppNavigation()
                    }
               }
          }
     }
}