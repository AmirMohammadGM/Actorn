package com.amir.actorn.ui.movie_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.amir.actorn.R

@Composable
fun MovieDetailAppBar(
          navigateUp : () -> Unit ,
          title : String ,
)
{
     Box(modifier = Modifier.fillMaxWidth()) {
          IconButton(onClick = navigateUp , modifier = Modifier.align(Alignment.Center)) {
               Icon(
                         imageVector = Icons.Rounded.ArrowBack ,
                         contentDescription = stringResource(id = R.string.cd_up_button) ,
                         tint = MaterialTheme.colors.onBackground
               )
          }
          Text(
                    text = "$title" ,
                    color = MaterialTheme.colors.onBackground ,
                    style = MaterialTheme.typography.h6 ,
                    textAlign = TextAlign.Center ,
                    modifier = Modifier
                              .fillMaxWidth()
                              .align(Alignment.Center)
          )
     }
}