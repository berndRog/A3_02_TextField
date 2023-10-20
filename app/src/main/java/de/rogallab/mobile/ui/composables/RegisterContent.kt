package de.rogallab.mobile.ui.composables

import android.util.Log
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.rogallab.mobile.logDebug

@Composable
fun RegisterContent(
   name:            String,          // State ↓
   onNameChange:    (String)->Unit  // Event ↑
) {

   // isErrorInName is used for UI visibility only -> save local
   var isErrorInName by remember { mutableStateOf(false) }

   Column(modifier = Modifier
      .padding(all = 8.dp)
      .fillMaxSize()
   ) {

      logDebug("ok>RegisterContent    .", "Composition {$name}")

      TextField(
         value = name,                              // State
         onValueChange = {
            onNameChange   (it)                     // Event ↑
            isErrorInName = it.length > 20
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

@Preview
@Composable
fun PreviewRegisterContent() {

   val name by rememberSaveable { mutableStateOf("") }

   RegisterContent(
      name = name,
      onNameChange = { it },
   )
}