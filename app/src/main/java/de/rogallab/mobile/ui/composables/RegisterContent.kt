package de.rogallab.mobile.ui.composables

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import de.rogallab.mobile.logDebug

@Composable
fun RegisterContent(
   name:            String,          // State ↓
   onNameChange:    (String)->Unit,  // Event ↑
   isErrorInName:   Boolean,         // State ↓
   onIsErrorChange: (Boolean)->Unit  // Event ↑
) {

   Column(modifier = Modifier
      .padding(all = 8.dp)
      .fillMaxSize()
   ) {

      logDebug("ok>RegisterContent    .", "Composition {$name}")

      TextField(
         value = name,                      // State
         onValueChange = {
            onNameChange   (it)             // Event ↑
            onIsErrorChange(it.length > 20) // Event ↑
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
