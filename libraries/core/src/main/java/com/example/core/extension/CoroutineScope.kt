package com.example.core.extension

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun CoroutineScope.launchInBackground(scope: suspend CoroutineScope.() -> Unit) {
    launch(context = Dispatchers.IO, block = scope)
}
