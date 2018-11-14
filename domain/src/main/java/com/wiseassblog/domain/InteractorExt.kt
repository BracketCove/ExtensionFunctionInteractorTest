package com.wiseassblog.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun CoroutineScope.getStringData(locator: ServiceLocator): String {
    //This is what I'm attempting to Mock; I don't want to use the actual implementation
    //of these extensions; otherwise I'm tightly coupling my tests to my domain implementation :(
    val listener: Channel<String> = Channel()

    launch(Dispatchers.IO) {
        listener.send(locator.source.getData())
    }

    return listener.receive()
}