package de.rogallab.mobile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

   // field = state observer
   private var _name: String by mutableStateOf( value = "" )
   // getter
   val name: String
      get() = _name
   // setter as function
   fun onNameChange(value: String) {
      logDebug("ok>MainViewModel","onNameChange $value")
      if(value != _name) _name = value // setter
   }

}