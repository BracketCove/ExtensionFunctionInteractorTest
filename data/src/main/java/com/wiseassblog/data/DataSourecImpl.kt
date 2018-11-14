package com.wiseassblog.data

import com.wiseassblog.domain.IDataSource
import kotlinx.coroutines.channels.Channel

class DataSourecImpl: IDataSource {
    override suspend fun getData() = "Oy Blin"
}