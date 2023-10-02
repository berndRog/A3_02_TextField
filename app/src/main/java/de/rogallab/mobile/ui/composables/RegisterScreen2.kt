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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun RegisterScreen2() {

   var name    by remember { mutableStateOf("") }
   var isError by remember { mutableStateOf(false) }

   Log.d("ok>RegisterScreen2    .", "Composition {$name}")

   RegisterContent(
      name            = name,                               // State ↓
      onNameChange    = { value:String -> name = value },   // Event ↑
      isErrorInName   = isError,                            // State ↓
      onIsErrorChange = { value:Boolean -> isError = value }// Event ↑
   )
}

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

      Log.d("ok>RegisterContent    .", "Composition {$name}")

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

@Preview
@Composable
fun PreviewRegisterScreen2() {
   RegisterScreen2()
}