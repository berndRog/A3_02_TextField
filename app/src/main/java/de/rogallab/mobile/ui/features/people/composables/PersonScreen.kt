package de.rogallab.mobile.ui.features.people.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import de.rogallab.mobile.ui.features.people.PeopleViewModel

@Composable
fun PersonScreenLocal(
) {
   var firstName by remember { mutableStateOf("") }
   var lastName by remember { mutableStateOf("") }

   Column(modifier = Modifier.padding(all = 8.dp).fillMaxSize()) {
      InputName(
         name = firstName,
         onNameChange = { it -> firstName = it },
         label = "Vorname local"
      )
      InputName(
         name = lastName,
         onNameChange = { lastName = it },
         label = "Nachname local"
      )
   }
}

@Composable
fun PersonScreenViewModel(
   viewModel: PeopleViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
   val personUiState by viewModel.personUiStateFlow.collectAsStateWithLifecycle()

   Column(modifier = Modifier.padding(all = 8.dp).fillMaxSize()) {
      InputName(
         name = personUiState.person.firstName,
         onNameChange = viewModel::onFirstNameChanged,
         label = "Vorname"
      )
      InputName(
         name = personUiState.person.lastName,
         onNameChange = viewModel::onLastNameChanged,
         label = "Nachname"
      )
   }
}


