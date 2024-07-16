package de.rogallab.mobile.ui.features.people.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.rogallab.mobile.domain.utils.logDebug
import de.rogallab.mobile.domain.utils.logError
import de.rogallab.mobile.ui.features.people.PersonUiEvent
import de.rogallab.mobile.ui.features.people.PersonUiState
import de.rogallab.mobile.ui.features.people.PersonViewModel

@Composable
fun PersonInputScreen(
   viewModel: PersonViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

   // Collect the latest PersonUiState from the StateFlow
   val personUiState: PersonUiState by viewModel.uiStateFlow.collectAsState()
   logDebug("[PersonInputScreen]", "Composition")

   // if error != null, log error
   personUiState.throwable?.let{ throwable ->
      logError("[PersonInputScreen]", "Error: ${throwable.localizedMessage}")

   // else, display input fields
   } ?: run {
      Column(
         modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxSize()
      ) {
         InputName(
            firstName = personUiState.person.firstName,
            onFirstNameChange = { it: String ->
               viewModel.onUiEvent(PersonUiEvent.OnFirstNameChanged(it))
            },
            lastName = personUiState.person.lastName,
            onLastNameChange = { it: String ->
               viewModel.onUiEvent(PersonUiEvent.OnLastNameChanged(it))
            }
         )
      }
   }

}
