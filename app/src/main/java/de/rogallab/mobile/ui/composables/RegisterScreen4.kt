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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import de.rogallab.mobile.logDebug

@Composable
fun RegisterScreen4(
   name:            String,          // State ↓
   onNameChange:    (String)->Unit  // Event ↑
) {
   logDebug("ok>RegisterScreen4    .", "Composition {$name}")

   RegisterContent2(
      name = name,                         // State ↓
      onNameChange = { onNameChange(it) }  // Event ↑
   )
}

@Composable
fun RegisterContent2(
   name:            String,         // State ↓
   onNameChange:    (String)->Unit  // Event ↑
) {
   // state is used only for UI visibility
   var isErrorInName by remember { mutableStateOf(false) }

   Column(modifier = Modifier
      .padding(all = 8.dp)
      .fillMaxSize()
   ) {

      logDebug("ok>RegisterContent    .", "Composition {$name}")

      TextField(
         value = name,                              // State ↓
         onValueChange = {
            onNameChange   (it)                     // Event ↑
            if(it.length > 20) isErrorInName = true // Event
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
            .testTag("NameTextField")
      )
   }
}