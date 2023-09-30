package de.rogallab.mobile

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.rogallab.mobile.ui.composables.RegisterScreen1
import de.rogallab.mobile.ui.composables.RegisterScreen3
import de.rogallab.mobile.ui.theme.AppTheme

class MainActivity : BaseActivity(TAG) {

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      setContent {

         var name    by rememberSaveable { mutableStateOf("") }
         var isError by rememberSaveable { mutableStateOf(false) }

         AppTheme() {

            Surface(
               modifier = Modifier.fillMaxSize(),
               color = MaterialTheme.colorScheme.background) {

               Log.d("ok>ComposeView        .", "Composition")
//             RegisterScreen1()
//             RegisterScreen2()

               RegisterScreen3(
                  name = name,
                  onNameChange = { it -> name = it },
                  isErrorInName = isError,
                  onIsErrorChange = { it -> isError = it}
               )

            }
         }
      }
   }

   companion object {        //12345678901234567890123
      private const val TAG = "ok>MainActivity       ."
   }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
   AppTheme() {
      Surface(
         modifier = Modifier.fillMaxSize(),
         color = MaterialTheme.colorScheme.background
      ) {
         RegisterScreen1()
      }
   }
}