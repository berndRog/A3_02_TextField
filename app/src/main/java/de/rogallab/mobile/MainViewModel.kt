package de.rogallab.mobile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

   private var _name: String by mutableStateOf( value = "" )
   val name: String                      // getter
      get() = _name
   fun onNameChange(value: String) {     // setter as function
      logDebug("ok>MainViewModel","onNameChange $value")
      if(value != _name) _name = value // setter
   }

}