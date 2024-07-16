package de.rogallab.mobile.ui.features.people

import androidx.lifecycle.ViewModel
import de.rogallab.mobile.domain.utils.logDebug
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PersonViewModel: ViewModel() {

   // Define a MutableStateFlow with the initial CountUiState
   private val _uiStateFlow: MutableStateFlow<PersonUiState> =
      MutableStateFlow(PersonUiState())
   // Expose the MutableStateFlow as a read-only StateFlow to the UI
   val uiStateFlow: StateFlow<PersonUiState> = _uiStateFlow.asStateFlow()

   // On each CountUiEvent, update the MutableStateFlow
   fun onUiEvent(event: PersonUiEvent) {
      logDebug("[CountViewModel]", "onUiEvent $event")
      when (event) {
         // Update the MutableStateflow
         is PersonUiEvent.OnFirstNameChanged -> _uiStateFlow.update { personUiState ->
            personUiState.copy( person =
               personUiState.person.copy(firstName = event.firstName))
         }
         is PersonUiEvent.OnLastNameChanged -> _uiStateFlow.update { personUiState ->
            personUiState.copy(person =
               personUiState.person.copy(lastName = event.lastName))
         }
         is PersonUiEvent.OnError -> _uiStateFlow.update { personUiState ->
            personUiState.copy(throwable = event.throwable)
         }
      }
   }
}