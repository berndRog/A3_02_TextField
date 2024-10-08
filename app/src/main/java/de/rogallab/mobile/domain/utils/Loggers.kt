package de.rogallab.mobile.domain.utils

import android.util.Log
import de.rogallab.mobile.MainActivity.Companion.isDebug
import de.rogallab.mobile.MainActivity.Companion.isInfo

fun logError(tag: String, message: String) {
   val msg = formatMessage(message)
   Log.e(tag, msg)
}
fun logWarning(tag: String, message: String) {
   val msg = formatMessage(message)
   Log.w(tag, msg)
}
fun logInfo(tag: String, message: String) {
   val msg = formatMessage(message)
   if(isInfo) Log.i(tag, msg)
}

fun logDebug(tag: String, message: String) {
   val msg = formatMessage(message)
   if (isDebug) Log.d(tag, msg)
}

private fun formatMessage(message: String) =
   String.format("%-70s %s", message, Thread.currentThread().toString())