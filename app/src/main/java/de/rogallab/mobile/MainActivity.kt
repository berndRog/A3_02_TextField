package de.rogallab.mobile

import android.os.Bundle
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

         AppTheme {

            Surface(
               modifier = Modifier.fillMaxSize(),
               color = MaterialTheme.colorScheme.background) {

               logInfo("ok>ComposeView        .", "Composition")
//             RegisterScreen1()
//             RegisterScreen2()

               RegisterScreen3(
                  name = name,
                  onNameChange = { name = it },
                  isErrorInName = isError,
                  onIsErrorChange = { isError = it}
               )

            }
         }
      }
   }

   companion object {
      const val isInfo = true
      const val isDebug = true
      //12345678901234567890123
      private const val TAG = "ok>MainActivity       ."
   }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
   AppTheme {
      Surface(
         modifier = Modifier.fillMaxSize(),
         color = MaterialTheme.colorScheme.background
      ) {
         RegisterScreen1()
      }
   }
}