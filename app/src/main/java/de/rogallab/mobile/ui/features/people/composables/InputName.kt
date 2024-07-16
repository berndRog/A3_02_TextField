package de.rogallab.mobile.ui.features.people.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
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
import de.rogallab.mobile.domain.utils.logDebug
@Composable
fun InputName1(
   firstName: String,                     // State ↓
   onFirstNameChange: (String) -> Unit,   // Event ↑
   lastName: String,                      // State ↓
   onLastNameChange: (String) -> Unit     // Event ↑
) {

   logDebug("[InputName]", "Composition:$firstName, $lastName")

   TextField(
      value = firstName,                           // State ↓
      onValueChange = { it: String -> // Event
         onFirstNameChange(it)                     // Event ↑
      },
      label = { Text(text = "Vorname") },
      singleLine = true,
      modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
   )

   TextField(
      value = lastName,                            // State ↓
      onValueChange = { it: String ->
         onLastNameChange(it)                      // Event ↑
      },
      label = { Text(text = "Nachname") },
      singleLine = true,
      modifier = Modifier.padding(top = 8.dp).fillMaxWidth()
   )
}

@Composable
fun InputName(
   firstName: String,                     // State ↓
   onFirstNameChange: (String) -> Unit,   // Event ↑
   lastName: String,                      // State ↓
   onLastNameChange: (String) -> Unit     // Event ↑
) {
   // isErrorInName is used for UI visibility only -> save local
   var isErrorInFirstName by remember { mutableStateOf(false) }
   var isErrorInLastName by remember { mutableStateOf(false) }

   logDebug("[InputName]", "Composition:$firstName, $lastName")

   OutlinedTextField(
      value = firstName,                           // State ↓
      onValueChange = { it: String -> // Event
         onFirstNameChange(it)                     // Event ↑
         isErrorInFirstName = it.length > 20
      },
      label = { Text(text = "Vorname") },
      singleLine = true,
      isError = isErrorInFirstName,
      supportingText = {
         if (isErrorInFirstName) {
            Text("Vorname ist zu lang (maximal 20 Zeichen)")
         }
      },
      modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
         .testTag("firstNameTextField")
   )

   OutlinedTextField(
      value = lastName,                            // State ↓
      onValueChange = { it: String ->
         onLastNameChange(it)                      // Event ↑
         isErrorInLastName = it.length > 20
      },
      label = { Text(text = "Nachname") },
      singleLine = true,
      isError = isErrorInLastName,
      supportingText = {
         if (isErrorInLastName) {
            Text("Nachname ist zu lang (maximal 20 Zeichen)")
         }
      },
      modifier = Modifier.fillMaxWidth()
         .testTag("lastNameTextField")
   )
}


@Composable
fun InputName3(
   firstName: String,                     // State ↓
   onFirstNameChange: (String) -> Unit,   // Event ↑
   lastName: String,                      // State ↓
   onLastNameChange: (String) -> Unit     // Event ↑
) {
   // isErrorInName is used for UI visibility only -> save local
   var isErrorInFirstName by remember { mutableStateOf(false) }
   var isErrorInLastName by remember { mutableStateOf(false) }

   logDebug("[InputName]", "Composition:$firstName, $lastName")

   TextField(
      value = firstName,                           // State ↓
      onValueChange = { it: String -> // Event
         onFirstNameChange(it)                     // Event ↑
         isErrorInFirstName = it.length > 20
      },
      label = { Text(text = "Vorname") },
      singleLine = true,
      isError = isErrorInFirstName,
      supportingText = {
         if (isErrorInFirstName) {
            Text("Vorname ist zu lang (maximal 20 Zeichen)")
         }
      },
      modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
         .testTag("firstNameTextField")
   )

   OutlinedTextField(
      value = lastName,                            // State ↓
      onValueChange = { it: String ->
         onLastNameChange(it)                      // Event ↑
         isErrorInLastName = it.length > 20
      },
      label = { Text(text = "Nachname") },
      singleLine = true,
      isError = isErrorInLastName,
      supportingText = {
         if (isErrorInLastName) {
            Text("Nachname ist zu lang (maximal 20 Zeichen)")
         }
      },
      modifier = Modifier.fillMaxWidth()
         .testTag("lastNameTextField")
   )
}

