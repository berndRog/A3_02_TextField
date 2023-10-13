package de.rogallab.mobile.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.rogallab.mobile.logDebug

@Composable
fun RegisterScreen1() {

   var name by rememberSaveable { mutableStateOf("") }
   var isErrorInName by remember { mutableStateOf(false) }

   Column(modifier = Modifier
      .padding(all = 4.dp)
      .fillMaxSize()
   ) {

      logDebug("ok>RegisterScreen1    .","Composition {$name}")

/*
      TextField(
         value = name,                   // State
         onValueChange = { it: String -> // Event
            name = it
         },
         placeholder = {
            Text( text = "Name" )
         },
         modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
      )
*/
      TextField(
         value = name,                   // State
         onValueChange = {
            name = it                    // Event
            isErrorInName = name.length > 20
         },
         placeholder = {
            Text( text = "Name"  )
         },
         singleLine = true,
         supportingText = {
            if(isErrorInName) {
               Text("Name ist zu lang (maximal 20 Zeichen)")
            }
         },
         isError = isErrorInName,
         modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
      )
   }
}

@Preview
@Composable
fun PreviewRegisterScreen1() {
   RegisterScreen1()
}