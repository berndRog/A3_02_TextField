package de.rogallab.mobile.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import de.rogallab.mobile.logDebug

@Composable
fun RegisterScreen4(
   name:            String,          // State ↓
   onNameChange:    (String)->Unit  // Event ↑
) {
   logDebug("ok>RegisterScreen4    .", "Composition {$name}")
   var isErrorInName by remember { mutableStateOf(false) }

   RegisterContent(
      name = name,                         // State ↓
      onNameChange = { onNameChange(it) },
      isErrorInName = isErrorInName,
      onIsErrorChange = { isErrorInName = it }
   )
}
