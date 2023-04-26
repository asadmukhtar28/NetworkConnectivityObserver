package com.asad.networkconnectivityobserver.utils.network

import kotlinx.coroutines.flow.Flow

interface NetworkConnectivityObserver {
    fun observer() : Flow<NetworkStatus>
}