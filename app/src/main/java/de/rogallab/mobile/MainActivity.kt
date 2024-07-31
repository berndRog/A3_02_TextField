package de.rogallab.mobile

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.rogallab.mobile.domain.utils.logDebug
import de.rogallab.mobile.ui.base.BaseActivity
import de.rogallab.mobile.ui.features.people.composables.PersonScreenLocal
import de.rogallab.mobile.ui.features.people.composables.PersonScreenViewModel
import de.rogallab.mobile.ui.theme.AppTheme

class MainActivity : BaseActivity(TAG) {

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      setContent {
         logDebug("[ComposeView]", "Composition")

         AppTheme {
            Surface(
               modifier = Modifier.fillMaxSize(),
               color = MaterialTheme.colorScheme.background
            ) {

               PersonScreenViewModel(   )
            }
         }
      }
   }
   companion object {
      const val isInfo = true
      const val isDebug = true
      //12345678901234567890123
      private const val TAG = "[MainActivity]"
   }
}


@Preview(showBackground = true)
@Composable
fun PreviewPersonInputScreenLocal() {
   AppTheme {
      Surface(
         modifier = Modifier.fillMaxSize(),
         color = MaterialTheme.colorScheme.background
      ) {
         PersonScreenLocal()
      }
   }
}

@Preview(showBackground = true)
@Composable
fun PreviewPersonInputScreenViewModel() {
   AppTheme {
      Surface(
         modifier = Modifier.fillMaxSize(),
         color = MaterialTheme.colorScheme.background
      ) {

         PersonScreenViewModel()
      }
   }
}