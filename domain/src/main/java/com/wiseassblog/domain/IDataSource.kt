package com.wiseassblog.domain

import kotlinx.coroutines.channels.Channel

interface IDataSource {

    suspend fun getData(): String
}