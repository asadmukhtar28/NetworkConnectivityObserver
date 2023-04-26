package com.asad.networkconnectivityobserver.utils.network

sealed class NetworkStatus {
    object Disconnected : NetworkStatus()
    object Unavailable : NetworkStatus()
    object Connected : NetworkStatus()
}