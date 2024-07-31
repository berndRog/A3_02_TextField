package de.rogallab.mobile.ui.features.people

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PeopleViewModel : ViewModel() {

   // Data Binding PersonScreen <=> PeopleViewModel
   private val _personUiStateFlow: MutableStateFlow<PersonUiState> = MutableStateFlow(PersonUiState())
   val personUiStateFlow: StateFlow<PersonUiState> = _personUiStateFlow.asStateFlow()

   fun onFirstNameChanged(firstName: String) {
      _personUiStateFlow.update { it:PersonUiState ->
         it.copy(person = it.person.copy(firstName = firstName))
      }
   }
   fun onLastNameChanged(lastName: String) {
      _personUiStateFlow.update { it:PersonUiState ->
         it.copy(person = it.person.copy(lastName = lastName))
      }
   }
}