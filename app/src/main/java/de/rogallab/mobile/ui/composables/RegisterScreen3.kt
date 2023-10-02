package de.rogallab.mobile.ui.composables

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RegisterScreen3(
   name:            String,          // State ↓
   onNameChange:    (String)->Unit,  // Event ↑
   isErrorInName:   Boolean,         // State ↓
   onIsErrorChange: (Boolean)->Unit  // Event ↑
) {

   Log.d("ok>RegisterScreen3    .", "Composition {$name}")

   RegisterContent(
      name = name,                         // State ↓
      onNameChange = { onNameChange(it) },
      isErrorInName = isErrorInName,
      onIsErrorChange = { onIsErrorChange(it) }
   )

}

@Preview
@Composable
fun PreviewRegisterScreen3() {

   var name    by rememberSaveable { mutableStateOf("") }
   var isError by rememberSaveable { mutableStateOf(false) }

   RegisterScreen3(
      name = name,
      onNameChange = { name = it },
      isErrorInName = isError,
      onIsErrorChange = { isError = it}
   )

}

@Preview
@Composable
fun PreviewRegisterContent() {

   val name    by rememberSaveable { mutableStateOf("") }
   val isError by rememberSaveable { mutableStateOf(false) }

   RegisterContent(
      name = name,                         // State ↓
      onNameChange = { it },
      isErrorInName = isError,
      onIsErrorChange = { it }
   )

}